#include "Client.h"

Client::Client(const ClientCommandParser& commandParser)
    : HOST(commandParser.getHost()), PORT(commandParser.getPort()) {}

void Client::run() const {
  ClientSocket clientSkt(HOST, PORT);
  HTTPProtocolReader reader;

  std::string line;
  while (reader.readLine(line)) clientSkt.send(line.c_str(), line.size());
  clientSkt.writeShutdown();

  std::stringbuf serverAnswer;
  clientSkt.recieve(serverAnswer);
  clientSkt.readShutdown();

  std::cout << serverAnswer.str();
}
