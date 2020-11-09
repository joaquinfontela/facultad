#include <iostream>

#include "ClientManager.h"
#include "FileReader.h"
#include "ResourcesManager.h"
#include "ServerCommandParser.h"

int main(int argc, char* argv[]) {
  ServerCommandParser commandParser;
  if (!commandParser.commandIsValid(argc, argv)) return 1;

  ResourcesManager resourcesManager;
  std::string rootFilePath = commandParser.getFilePath();
  FileReader fileReader;
  resourcesManager.addResource("/", fileReader.getFileContent(rootFilePath));

  const std::string PORT = commandParser.getPort();

  ClientManager clientManager(PORT, resourcesManager);
  clientManager.start();
  clientManager.join();

  return 0;
}