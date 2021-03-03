#include "CommandParser.h"

CommandParser::CommandParser() {}

bool CommandParser::commandIsValid(const int argc, char* argv[]) {
  return argc == 3;
}

std::string CommandParser::getPort() const { return port; }
