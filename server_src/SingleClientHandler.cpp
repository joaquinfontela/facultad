#include "SingleClientHandler.h"

SingleClientHandler::SingleClientHandler(ServerSocket&& peer,
                                         ResourcesManager& resources)
    : peerSkt(std::move(peer)), resourcesManager(resources) {
  dead = false;
}

SingleClientHandler::~SingleClientHandler() { this->join(); }

void SingleClientHandler::run() {
  std::stringbuf fileContent;
  peerSkt.recieve(fileContent);
  peerSkt.readShutdown();

  protocolParser.parseFile(fileContent.str());

  ServerAnswererFactory serverAnswerFactory;
  ServerAnswerer* serverAnswerer =
      serverAnswerFactory.getServerAnswerer(protocolParser);

  std::string answer = serverAnswerer->getAnswer(resourcesManager);
  delete serverAnswerer;

  peerSkt.send(answer.c_str(), answer.size());
  peerSkt.writeShutdown();
  dead = true;
}

bool SingleClientHandler::isDead() const { return dead; }
