#include "editor.h"

#include "QPainter"
#include "QPen"
#include "decoration_tile_factory.h"
#include "door_tile_factory.h"
#include "item_tile_factory.h"
#include "size_window.h"
#include "tiles_container.h"
#include "ui_editor.h"
#include "wall_tile_factory.h"
#include "map_painter.h"
#include <QMessageBox>
#include "open_window.h"
#include "../../common/includes/YAML/YAMLConfigReader.h"
#include "../../common/includes/YAML/YAMLMapReader.h"
#include "../../common/includes/YAML/YAMLMapWriter.h"
#include "save_window.h"
#include "QGraphicsScene"
#include "QGraphicsView"
#include "map_scene.h"
#include "tile_container_actions.h"
#include "map_actions.h"

#define BASE_SIDE_SIZE 40
#define PLUS_SIDE_SIZE 60
#define LARGE_SIDE_SIZE 80
#define WHITE_BOX_PATH "./fondo_blanco.png"
#define WALL_TILESET_PATH "./elementos_mapa/paredes/wall_tileset.png"
#define ITEM_TILESET_PATH "./elementos_mapa/items/items_tileset.png"
#define DECORATION_TILESET_PATH "./elementos_mapa/decoraciones/decoration_tileset.png"
#define DOOR_TILESET_PATH "./elementos_mapa/puertas/door_tileset.png"
#define RESPAWN_ICON_PATH "./elementos_mapa/otros/respawn_icon.png"

void Editor::initialize_tile_container() {
  tile_container_actions* ef = new tile_container_actions(this);
  tiles_container_scene = new tiles_container();
  ui->graphics_tiles_container->setScene(tiles_container_scene);
  ui->graphics_tiles_container->setAlignment(Qt::AlignTop);
  ui->graphics_tiles_container->installEventFilter(ef);
}

void Editor::initialize_map_container(int col, int row) {
  my_map_scene = new class map_scene(this, col, row, this->actual_tile_size());
  ui->graphics_map_container->setScene(my_map_scene);
  this->mc = new map_canvas(col, row);
  map_actions* ma = new map_actions(this, my_map_scene);
  ui->graphics_map_container->installEventFilter(ma);

  ui->actionsafe->setEnabled(true);
}

Editor::Editor(QWidget* parent) : QMainWindow(parent), ui(new Ui::Editor){
  ui->setupUi(this);
  initialize_tile_container();
  this->tile_item_selected = NULL;
  this->tile_sizes = {BASE_SIDE_SIZE, PLUS_SIDE_SIZE, LARGE_SIDE_SIZE};
  this->actual_tiles_size_index = 0;
  ui->actionsafe->setEnabled(false);
  this->actual_map_saved = false;
  ui->actionZoom_out->setEnabled(false);
  this->eraser_on = false;
}

Editor::~Editor() { delete ui; }

int Editor::actual_tile_size(){
    return this->tile_sizes.at(actual_tiles_size_index);
}

void Editor::on_actionEXIT_triggered() { QApplication::quit(); }

void Editor::on_actionNew_triggered() {
  size_window sw(this);
  sw.setModal(true);
  sw.exec();
}

void Editor::on_actionParedes_triggered() {
  tile_factory* factory = new wall_tile_factory();
  this->tiles_container_scene->update_tileset(WALL_TILESET_PATH , 6, factory);
}

void Editor::on_actionPuertas_triggered() {
  tile_factory* factory = new door_tile_factory();
  this->tiles_container_scene->update_tileset(DOOR_TILESET_PATH, 2, factory);
}

void Editor::on_actionBorrador_triggered() {
  this->eraser_on = true;
}

void Editor::on_actionDecoraciones_triggered() {
  tile_factory* factory = new decoration_tile_factory();
  this->tiles_container_scene->update_tileset(DECORATION_TILESET_PATH, 7, factory);
}

void Editor::on_actionItems_triggered() {
  tile_factory* factory = new item_tile_factory();
  this->tiles_container_scene->update_tileset(ITEM_TILESET_PATH, 6, factory);
}

void Editor::paint_map(){
}

void Editor::on_actionZoom_in_triggered()
{
    this->actual_tiles_size_index--;
    this->paint_map();
    if(actual_tiles_size_index == 0){
        ui->actionZoom_in->setEnabled(false);
    }
}

void Editor::on_actionZoom_out_triggered()
{
    if(actual_tiles_size_index == 0){
        ui->actionZoom_out->setEnabled(true);
    }
    this->actual_tiles_size_index++;
    this->paint_map();

    if(actual_tiles_size_index == 2){
        ui->actionZoom_in->setEnabled(false);
    }
}

void Editor::on_actionOpen_triggered()
{
    open_window ow(this);
    ow.setModal(true);
    ow.exec();
    this->paint_map();
}

void Editor::save_map(){
    if(actual_map_saved){
        std::string name_path = this->actual_map_name + ".YAML";
        YAMLMapWriter* map_creator = new YAMLMapWriter(name_path);
        TileMatrix matrix = this->mc->grilla;
        map_creator->createYamlMapFile(matrix);
        delete map_creator;
    }else{
        save_window sw(this);
        sw.setModal(true);
        sw.exec();
        actual_map_saved = true;
    }
}

void Editor::on_actionsafe_triggered()
{
    this->save_map();
}

void Editor::on_actionRespawn_triggered()
{
    this->tile_item_selected = new tile_item( RESPAWN_ICON_PATH , 0, false);
}

void Editor::on_actionSave_and_exit_triggered()
{
    this->save_map();
    QApplication::quit();
}
