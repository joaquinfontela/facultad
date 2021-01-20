#ifndef __MATCH_H__
#define __MATCH_H__

#include <atomic>
#include <list>
#include <map>
#include <queue>

#include "../Model/Game/Game.h"
#include "../../../common/includes/Queue/WaitingQueue.h"
#include "../Control/Command/Command.h"
#include "../Control/Notification/Notification.h"
#include "../Server/ClientCommunication.h"
#include "../Server/ConnectionHandler.h"
#include "Engine.h"

class Engine;
class ClientCommunication;

class Match {
 private:
  std::atomic<bool> cont;
  Engine* engine;
  WaitingQueue<Command*> commands;
  WaitingQueue<Notification*> notis;
  Game game;

  int ID;
  unsigned int playerCount;
  bool running;
  std::map<int, ClientCommunication*> players;

 public:
  Match();
  ~Match();
  explicit Match(int lobbyID);

  // Fuerza el cierre del Match.
  void forceShutdown();

  // Devuelve si el Match tiene cierto ID o no.
  bool hasID(int lobbyID);

  // Comienza el Match.
  void start();

  // Devuelve si la partida efectivamente termino.
  bool hasEnded();

  // Agrega un jugador a la partida y devuelve la instancia del ConnectionHandler que maneja la interaccion con dicho usuario.
  ConnectionHandler* addPlayerToMatch(ClientCommunication* player);
};

#endif
