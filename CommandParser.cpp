#include "CommandParser.h"

CommandParser::CommandParser() {}

bool CommandParser::commandIsValid(int argc, char* argv[]) { return argc == 3; }

std::string& CommandParser::getPort() { return port; }