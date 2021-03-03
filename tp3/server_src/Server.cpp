#include "Server.h"

Server::Server(const ServerCommandParser& commandParser)
    : PORT(commandParser.getPort()), resourcesManager() {
  std::string rootFilePath = commandParser.getFilePath();
  FileReader fileReader;
  resourcesManager.addResource("/", fileReader.getFileContent(rootFilePath));
}

void Server::run() {
  ClientManager clientManager(PORT, resourcesManager);
  clientManager.start();
  std::string input = "";
  while (input != "q") {
    std::cin >> input;
  }
}
