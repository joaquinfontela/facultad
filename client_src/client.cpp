#include <iostream>

#include "ClientCommandParser.h"
#include "ClientSocket.h"
#include "HTTPProtocolReader.h"

int main(int argc, char* argv[]) {
  ClientCommandParser commandParser;
  if (!commandParser.commandIsValid(argc, argv)) return 0;

  ClientSocket client;
  HTTPProtocolReader http;

  const std::string HOST = commandParser.getHost();
  const std::string PORT = commandParser.getPort();

  std::string line;
  client._connect(HOST, PORT);

  while (http.readLine(line)) client._send(line, line.size());

  return 0;
}