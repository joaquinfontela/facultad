#include "SingleClientHandler.h"

SingleClientHandler::SingleClientHandler(ServerSocket&& peer,
                                         ResourcesManager& resources)
    : protocolParser(), resourcesManager(resources) {
  peerSkt = std::move(peer);
}

SingleClientHandler::~SingleClientHandler() { this->join(); }

void SingleClientHandler::run() {
  std::string fileContent;
  peerSkt.recieve(fileContent, 1000);
  peerSkt.readShutdown();

  protocolParser.parseFile(fileContent);

  ServerAnswererFactory serverAnswerFactory;
  ServerAnswerer&& serverAnswerer =
      serverAnswerFactory.getServerAnswerer(protocolParser);

  std::string answer = serverAnswerer.getAnswer(resourcesManager);
  peerSkt.send(answer, answer.size());
  peerSkt.writeShutdown();
  dead = true;
}

bool SingleClientHandler::isDead() { return dead; }