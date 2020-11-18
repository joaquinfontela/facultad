#include "Client.h"
#define BUFFER_LEN 1000

Client::Client(const ClientCommandParser& commandParser)
    : HOST(commandParser.getHost()), PORT(commandParser.getPort()) {}

void Client::run() const {
  ClientSocket clientSkt(HOST, PORT);
  HTTPProtocolReader reader;

  std::string line;
  while (reader.readLine(line)) clientSkt.send(line.c_str(), line.size());
  clientSkt.writeShutdown();

  char serverAnswer[BUFFER_LEN];
  clientSkt.recieve(serverAnswer, 1000);
  clientSkt.readShutdown();

  std::cout << serverAnswer;
}
