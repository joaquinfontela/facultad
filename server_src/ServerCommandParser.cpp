#include "ServerCommandParser.h"

ServerCommandParser::ServerCommandParser() {}

bool ServerCommandParser::commandIsValid(int argc, char* argv[]) {
  bool isValid;
  if ((isValid = CommandParser::commandIsValid(argc, argv))) {
    std::string portAux(argv[1]);
    port = portAux;
    std::string filePathAux(argv[2]);
    filePath = filePathAux;
  }
  return isValid;
}

std::string& ServerCommandParser::getFilePath() { return filePath; }