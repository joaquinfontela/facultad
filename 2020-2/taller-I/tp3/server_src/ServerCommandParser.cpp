#include "ServerCommandParser.h"
#define PORT 1
#define FILE_PATH 2

ServerCommandParser::ServerCommandParser() : CommandParser() {}

bool ServerCommandParser::commandIsValid(const int argc, char* argv[]) {
  bool isValid;
  if ((isValid = CommandParser::commandIsValid(argc, argv))) {
    std::string portAux(argv[PORT]);
    port = portAux;
    std::string filePathAux(argv[FILE_PATH]);
    filePath = filePathAux;
  }
  return isValid;
}

std::string ServerCommandParser::getFilePath() const { return filePath; }
