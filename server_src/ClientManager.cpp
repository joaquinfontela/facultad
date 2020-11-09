#include "ClientManager.h"
#define QUEUE_LENGTH 5

ClientManager::ClientManager(const std::string& port,
                             ResourcesManager& resources)
    : serverSkt(), clientHandlers(), resourcesManager(resources) {
  serverSkt.bindListen(port, true, QUEUE_LENGTH);
}

ClientManager::~ClientManager() { this->join(); }

void ClientManager::run() {
  int i = 0;
  while (i < 5) {
    ServerSocket peerSkt;
    try {
      peerSkt(serverSkt.accept());
    } catch (std::runtime_error e) {
      break;
    }
    SingleClientHandler s(peerSkt, resourcesManager);
    s.start();
    // clientCleaner();
    i++;
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