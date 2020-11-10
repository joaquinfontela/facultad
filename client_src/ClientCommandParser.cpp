#include "ClientCommandParser.h"

ClientCommandParser::ClientCommandParser() : CommandParser() {}

bool ClientCommandParser::commandIsValid(const int argc, char* argv[]) {
  bool isValid;
  if ((isValid = CommandParser::commandIsValid(argc, argv))) {
    std::string hostAux(argv[1]);
    host = hostAux;
    std::string portAux(argv[2]);
    port = portAux;
  }
  return isValid;
}

std::string ClientCommandParser::getHost() { return host; }
