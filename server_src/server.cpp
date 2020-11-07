#include <iostream>

#include "HTTPProtocolParser.h"
#include "ServerAnswer.h"
#include "ServerCommandParser.h"
#include "ServerSocket.h"

int main(int argc, char* argv[]) {
  ServerCommandParser commandParser;
  if (!commandParser.commandIsValid(argc, argv)) return 1;
  ServerSocket server;
  HTTPProtocolParser http;
  std::string fileContent;
  const std::string PORT = commandParser.getPort();

  server.bindListen(PORT, true, 5);
  server._accept();
  server.recieve(fileContent, 1000);

  http.parseFile(fileContent);

  return 0;
}