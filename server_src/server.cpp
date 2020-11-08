#include <iostream>

#include "FileReader.h"
#include "HTTPProtocolParser.h"
#include "ServerAnswerer.h"
#include "ServerAnswererFactory.h"
#include "ServerCommandParser.h"
#include "ServerSocket.h"

int main(int argc, char* argv[]) {
  ServerCommandParser commandParser;
  if (!commandParser.commandIsValid(argc, argv)) return 1;
  ServerSocket server;
  HTTPProtocolParser parser;
  FileReader fileReader;
  const std::string PORT = commandParser.getPort();

  std::map<std::string, std::string> resources;
  std::string rootFilePath = commandParser.getFilePath();
  resources.insert({"/", fileReader.getFileContent(rootFilePath)});
  resources.insert({"/test", "<html>\ntestBody\n<html>\n"});

  server.bindListen(PORT, true, 5);
  server._accept();
  std::string fileContent;
  server.recieve(fileContent, 1000);

  parser.parseFile(fileContent);

  ServerAnswererFactory serverAnswerFactory;
  ServerAnswerer&& serverAnswerer =
      serverAnswerFactory.getServerAnswerer(parser);

  std::string answer = serverAnswerer.getAnswer(resources);
  server._send(answer, answer.size());

  return 0;
}