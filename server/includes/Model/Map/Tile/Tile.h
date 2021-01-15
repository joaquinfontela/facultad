#ifndef __TILE_H__
#define __TILE_H__

#include <vector>

#include "../../../../../common/includes/Queue/WaitingQueue.h"
#include "../../../Control/Notification/PlayerPickUpItem.h"
#include "../../../Control/Notification/Notification.h"
#include "../../Door/Door.h"
#include "../../Item/Item.h"
#include "../../Item/Weapon/Weapon.h"
#include "../../Player/Player.h"
#include "../../Wall/BlueWall.h"
#include "../../Wall/Wall.h"
#include "../Map.h"

class Player;
class Item;

class Tile {
 private:
  Door* door;
  Wall* wall;
  std::vector<Player*> players;
  std::vector<Item*> items;
  std::vector<Weapon*> weapons;
  bool isWall();
  void deleteDoor();
  void deleteWall();
  void deleteItemDrops();
  void deleteWeaponDrops();

 public:
  Tile();
  void addItemDrop(Item* item);
  void addWeaponDrop(Weapon* weapon);
  void addDoor(Door* door);
  void addWall(Wall* wall);

  void addAmmoDrop();
  void addKeyDrop();

  bool moveDoor(Player* p);

  // Agrega un jugador al Tile.
  void addPlayer(Player* p);

  void pickUpItems(double x, double y, Player* p, WaitingQueue<Notification*>& notis);

  // Remueve el jugador del Tile.
  void removePlayerFromTile(Player* p);

  bool forceDoorStatusChange();

  // Devuelve el primer jugador con el que colisiona el punto (x, y). Nullptr si
  // no existe tal jugador.
  Player* playerCollision(double x, double y, Player* p);

  // Devuelve True si la celda es una pared.
  bool checkWall();

  // Setea la celda como pared y colisionable.
  void setWall();

  // Devuelve true si autoriza el movimiento de un jugador a la posicion (x, y)
  bool allowMovement(double x, double y, Player* p, WaitingQueue<Notification*>& notis);

  ~Tile();
};

#endif
