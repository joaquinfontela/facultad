#include "Client.h"

Client::Client(const ClientCommandParser& commandParser)
    : HOST(commandParser.getHost()), PORT(commandParser.getPort()) {}

void Client::run() const {
  ClientSocket clientSkt;
  HTTPProtocolReader reader;

  clientSkt.connect(HOST, PORT);

  std::string line;
  while (reader.readLine(line)) clientSkt.send(line, line.size());
  clientSkt.writeShutdown();

  std::string serverAnswer;
  clientSkt.recieve(serverAnswer, 1000);
  clientSkt.readShutdown();

  std::cout << serverAnswer;
}
