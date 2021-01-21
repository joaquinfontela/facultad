#include "ClientMapLoader.h"
#include "clientprotocol.h"

#include <iostream>

ClientMapLoader::ClientMapLoader(std::string& yamlFile, unsigned int dimx,
                                 unsigned int dimy)
    : yamlMapReader(yamlFile), uniqueid(1) {
  std::vector<int> mapDimensions = yamlMapReader.getMapDimensions();
  this->dimx = mapDimensions.at(0);
  this->dimy = mapDimensions.at(1);
}

int* ClientMapLoader::getWallIdMatrix() {
  int* matrix = (int*)calloc(dimx * dimy, sizeof(int));

  int FROM_ID = yamlMapReader.getWallsIdLimits().at(0);
  int TO_ID = yamlMapReader.getWallsIdLimits().at(1);
  std::map<int, std::vector<Coordinate>> wallTypeCoordinateMap = yamlMapReader.getWallTypeCoordinateMap();

  int id;
  for (id = FROM_ID; id <= TO_ID; id++) {

    if (!this->idIsInCoordinateMap(wallTypeCoordinateMap, id))
      continue;
    std::vector<Coordinate> coordinatesWhereWallWithCurrentIdIsIn = wallTypeCoordinateMap[id];
    for (Coordinate& c : coordinatesWhereWallWithCurrentIdIsIn) {
      matrix[(c.getY() - 1) * this->dimx + (c.getX() - 1)] = this->convertYamlFileWallIdToProtocolWallSkinId(id);
    }
  }

  int DOOR_FROM = yamlMapReader.getDoorsIdLimits().at(0);
  int DOOR_TO = yamlMapReader.getDoorsIdLimits().at(1);

  for(id = DOOR_FROM; id <= DOOR_TO; id++){
    std::vector<Coordinate> pos= yamlMapReader.getTileCoordinatesWhereObjectIsIn(id);

    for(Coordinate& c : pos){
        matrix[(c.getY() - 1) * this->dimx + (c.getX() - 1)] = this->convertYamlFileWallIdToProtocolWallSkinId(id);
    }
  }
  return matrix;
}

std::vector<Drawable*> ClientMapLoader::getDrawableItemList() {
  int FROM_ID = yamlMapReader.getWeaponsIdLimits().at(0);
  int TO_ID = yamlMapReader.getItemsIdLimits().at(1);
  std::map<int, std::vector<Coordinate>> itemTypeCoordinateMap = yamlMapReader.getPartialItemCoordinateMap(FROM_ID, TO_ID);
  int id;
  std::vector<Drawable*> drawableItems;

  for (id = FROM_ID; id <= TO_ID; id++) {
    if (!this->idIsInCoordinateMap(itemTypeCoordinateMap, id)) continue;
    std::vector<Coordinate> coordinatesWhereItemWithCurrentIdIsIn = itemTypeCoordinateMap[id];
    for (Coordinate& c : coordinatesWhereItemWithCurrentIdIsIn) {
      drawableItems.push_back(
          new Drawable(c.getY() - 0.5 , c.getX() - 0.5,
                       this->convertYamlFileItemIdToProtocolItemSkinId(id),
                       uniqueid));
      uniqueid++;
    }
  }
  return drawableItems;
}

bool ClientMapLoader::idIsInCoordinateMap(
    std::map<int, std::vector<Coordinate>>& coordinateMap, int itemId) {
  return (coordinateMap.find(itemId) != coordinateMap.end());
}

unsigned int ClientMapLoader::convertYamlFileWallIdToProtocolWallSkinId(
    int yamlFileId) {
  switch (yamlFileId) {
    case 301:
    case 351:
      return BLUEWALL;
      break;

    case 302:
    case 352:
      return PURPLEWALL;
      break;

    case 303:
    case 353:
      return GREY_STONE_WALL;
      break;

    case 304:
    case 354:
      return WOODEN_WALL;
      break;
    case 201:
      return DOOR;
      break;

    case 305:
      return MOSSY;
      break;

    case 306:
      return WALL2_SPRITE;
      break;
    case 307:
      return BRICKWALL;
      break;

    case 308:
      return PURPLEWALL;
      break;

    case 309:
      return PURPLEWALL;
      break;

    default:
      throw std::runtime_error("Wall id recieved not valid.");
  }
}

unsigned int ClientMapLoader::convertYamlFileItemIdToProtocolItemSkinId(
    int yamlFileId) {
  switch (yamlFileId) {
    case 3:
      return MACHINEGUNITEM;
      break;

    case 4:
      return CHAINGUNITEM;
      break;

    case 5:
      return ROCKETLAUNCHERITEM;
      break;

    case 101:
      return AMMO;
      break;

    case 102:
      return BLOOD;
      break;

    case 103:
      return CHEST;
      break;

    case 104:
      return GOLDENCROSS;
      break;

    case 105:
      return GOLDENCROWN;
      break;

    case 106:
      return GOLDENCUP;
      break;

    case 107:
      return FOOD;
      break;

    case 108:
      return GOLDENKEY;
      break;

    case 109:
      return MEDKIT;
      break;

    case 404:
      return FLYINGMISSILE;
      break;

    default:
      throw std::runtime_error("Item id recieved not valid.");
  }
}
