#include "ClientManager.h"
#define QUEUE_LENGTH 5

ClientManager::ClientManager(const std::string& port,
                             ResourcesManager& resourcesManager)
    : serverSkt(), protocolParser() {
  this->resourcesManager = resourcesManager;
  serverSkt.bindListen(port, true, QUEUE_LENGTH);
}

void ClientManager::run() {
  int i = 0;
  while (i < 3) {
    Socket peer(serverSkt.accept());
    std::string fileContent;
    peer.recieve(fileContent, 1000);

    protocolParser.parseFile(fileContent);

    ServerAnswererFactory serverAnswerFactory;
    ServerAnswerer&& serverAnswerer =
        serverAnswerFactory.getServerAnswerer(protocolParser);

    std::string answer = serverAnswerer.getAnswer(resourcesManager);
    peer.send(answer, answer.size());
    i++;
  }
}