#include "ClientManager.h"
#define QUEUE_LENGTH 5

ClientManager::ClientManager(const std::string& port,
                             ResourcesManager& resources)
    : serverSkt(), clientHandlers(), resourcesManager(resources) {
  serverSkt.bindListen(port, true, QUEUE_LENGTH);
}

ClientManager::~ClientManager() { this->join(); }

void ClientManager::run() {
  while (true) {
    ServerSocket peerSkt;
    try {
      peerSkt(serverSkt.accept());
    } catch (std::runtime_error e) {
      break;
    }
    std::string fileContent;
    peerSkt.recieve(fileContent, 1000);

    HTTPProtocolParser protocolParser;
    protocolParser.parseFile(fileContent);

    ServerAnswererFactory serverAnswerFactory;
    ServerAnswerer&& serverAnswerer =
        serverAnswerFactory.getServerAnswerer(protocolParser);

    std::string answer = serverAnswerer.getAnswer(resourcesManager);
    peerSkt.send(answer, answer.size());
    // clientCleaner();
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