#include "ClientCommandParser.h"
#include "ClientSocket.h"

int main(int argc, char* argv[]) {
  ClientCommandParser commandParser;
  if (!commandParser.commandIsValid(argc, argv)) return 0;
  ClientSocket client;
  std::string message = "Hola papa, como estas?";
  std::string HOST = commandParser.getHost();
  std::string PORT = commandParser.getPort();

  client._connect(HOST, PORT);
  client._send(message, message.size());

  return 0;
}