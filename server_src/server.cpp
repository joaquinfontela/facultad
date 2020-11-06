#include <iostream>

#include "HTTPProtocolParser.h"
#include "ServerCommandParser.h"
#include "ServerSocket.h"

int main(int argc, char* argv[]) {
  ServerCommandParser commandParser;
  if (!commandParser.commandIsValid(argc, argv)) return 1;
  ServerSocket server;
  std::string buffer;
  std::string PORT = commandParser.getPort();

  server.bindListen(PORT, true, 5);
  server._accept();
  server.recieve(buffer, 1000);

  std::cout << buffer << std::endl;

  return 0;
}