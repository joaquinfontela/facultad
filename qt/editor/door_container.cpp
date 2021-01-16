#include "door_container.h"
#include "tiles_container.h"
#include <QImage>
#include <QLabel>
#include "tileset.h"
#include "tile.h"
#include "door_tile.h"
#include "door_tile_factory.h"
#include <vector>
#include <iostream>

#define PATH ":/game_element/elementos_mapa/paredes.png"
#define COL 2
#define ROW 8
#define MARGIN 10
#define HEIGHT 501
#define WIDTH 151

door_container::door_container()
{
    QImage* image = new QImage(PATH);
    QLabel* label = new QLabel();
    this->label = label;
    tileset ts(*image, COL, ROW);
    ts.copy_to_label(label);
    this->addWidget(label);
}

tile* door_container::tile_clicked(int x, int y){
    if(is_inside(x, y, MARGIN, WIDTH, HEIGHT)){
        std::vector<int> coordinates = get_tile_coordinate(x, y, COL, ROW);
        door_tile_factory factory;
        return factory.get_tile(coordinates);
    }
    return NULL;
}
