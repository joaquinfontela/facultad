#include "ClientCommandParser.h"
#include "ClientSocket.h"
#include "HTTPProtocolReader.h"

int main(int argc, char* argv[]) {
  ClientCommandParser commandParser;
  if (!commandParser.commandIsValid(argc, argv)) return 0;

  ClientSocket client;
  std::string FILE_NAME("test.txt");
  HTTPProtocolReader http(FILE_NAME);
  std::string buf(http.getFileContent());

  std::string HOST = commandParser.getHost();
  std::string PORT = commandParser.getPort();

  client._connect(HOST, PORT);
  client._send(buf, buf.size());

  return 0;
}