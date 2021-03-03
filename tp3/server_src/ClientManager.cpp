#include "ClientManager.h"
#define QUEUE_LENGTH 5

ClientManager::ClientManager(const std::string& port,
                             ResourcesManager& resources)
    : serverSkt(port, true, 10), clientHandlers(), resourcesManager(resources) {
  this->port = port;
  continueRunning = true;
}

ClientManager::~ClientManager() {
  continueRunning = false;
  for (SingleClientHandler* s : clientHandlers) {
    delete s;
  }
  serverSkt.readShutdown();
  serverSkt.writeShutdown();
  serverSkt.close();
  this->join();
}

void ClientManager::run() {
  while (continueRunning) {
    ServerSocket peerSkt;
    try {
      peerSkt(serverSkt.accept());
    } catch (std::invalid_argument& e) {
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
      ++it;
    }
  }
}
