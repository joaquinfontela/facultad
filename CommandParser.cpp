#include "CommandParser.h"

CommandParser::CommandParser(const int argc, char** argv) {
  CommandValidator commandValidator(argc, argv);
  if (!commandValidator.commandIsValid()) {
    throw std::invalid_argument("Invalid command");
  }

  this->parseArguments(argc, argv);
}

void CommandParser::parseArguments(const int argc, char** argv) {
  this->numberOfThreads = strtol((char*)argv[1], (char**)NULL, 10);

  int argNumber = 2;
  while (argNumber < argc) {
    std::string fileName(argv[argNumber]);
    this->fileNames.push_back(fileName);
    argNumber++;
  }
}

std::list<std::string>& CommandParser::getFileNames() {
  return this->fileNames;
}