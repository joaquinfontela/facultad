#include "ClientManager.h"
#define QUEUE_LENGTH 5

ClientManager::ClientManager(const std::string& port,
                             ResourcesManager& resources)
    : serverSkt(), clientHandlers(), resourcesManager(resources) {
  serverSkt.bindListen(port, true, QUEUE_LENGTH);
}

ClientManager::~ClientManager() {
  for (SingleClientHandler* s : clientHandlers) {
    delete s;
  }
  serverSkt.~ServerSocket();
  this->join();
}

void ClientManager::run() {
  while (true) {
    ServerSocket peerSkt;
    try {
      peerSkt(serverSkt.accept());
    } catch (std::invalid_argument e) {
      break;
    }
    SingleClientHandler* s =
        new SingleClientHandler(std::move(peerSkt), resourcesManager);
    clientHandlers.push_back(s);
    s->start();
    clientCleaner();
  }
}

void ClientManager::clientCleaner() {
  clientHandlersIterator it = clientHandlers.begin();
  while (it != clientHandlers.end()) {
    if ((**it).isDead()) {
      delete *it;
      it = clientHandlers.erase(it);
    } else {
      it++;
    }
  }
}
