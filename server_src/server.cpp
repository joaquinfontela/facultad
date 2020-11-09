#include <iostream>

#include "ClientManager.h"
#include "FileReader.h"
#include "ResourcesManager.h"
#include "ServerCommandParser.h"

int main(int argc, char* argv[]) {
  ServerCommandParser commandParser;
  if (!commandParser.commandIsValid(argc, argv)) return 1;

  FileReader fileReader;
  const std::string PORT = commandParser.getPort();

  ResourcesManager resourcesManager;
  std::string rootFilePath = commandParser.getFilePath();
  resourcesManager.addResource("/", fileReader.getFileContent(rootFilePath));

  ClientManager clientManager(PORT, resourcesManager);
  clientManager.start();
  clientManager.join();

  return 0;
}