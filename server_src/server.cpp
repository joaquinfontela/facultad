#include <iostream>

#include "FileReader.h"
#include "HTTPProtocolParser.h"
#include "ResourcesManager.h"
#include "ServerAnswerer.h"
#include "ServerAnswererFactory.h"
#include "ServerCommandParser.h"
#include "ServerSocket.h"

int main(int argc, char* argv[]) {
  ServerCommandParser commandParser;
  if (!commandParser.commandIsValid(argc, argv)) return 1;
  ServerSocket serverSocket;
  HTTPProtocolParser parser;
  FileReader fileReader;
  const std::string PORT = commandParser.getPort();

  ResourcesManager resources;
  std::string rootFilePath = commandParser.getFilePath();
  resources.addResource("/", fileReader.getFileContent(rootFilePath));

  serverSocket.bindListen(PORT, true, 5);
  Socket peer(serverSocket.accept());
  std::string fileContent;
  peer.recieve(fileContent, 1000);

  parser.parseFile(fileContent);

  ServerAnswererFactory serverAnswerFactory;
  ServerAnswerer&& serverAnswerer =
      serverAnswerFactory.getServerAnswerer(parser);

  std::string answer = serverAnswerer.getAnswer(resources);
  peer.send(answer, answer.size());

  return 0;
}