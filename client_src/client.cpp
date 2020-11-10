#include <iostream>

#include "ClientCommandParser.h"
#include "ClientSocket.h"
#include "HTTPProtocolReader.h"

int main(int argc, char* argv[]) {
  ClientCommandParser commandParser;
  if (!commandParser.commandIsValid(argc, argv)) return 0;

  ClientSocket client;
  HTTPProtocolReader reader;

  const std::string HOST = commandParser.getHost();
  const std::string PORT = commandParser.getPort();
  client.connect(HOST, PORT);

  std::string line;
  while (reader.readLine(line)) client.send(line, line.size());
  client.writeShutdown();

  std::string serverAnswer;
  client.recieve(serverAnswer, 1000);
  client.readShutdown();

  std::cout << serverAnswer;

  return 0;
}
