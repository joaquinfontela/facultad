#include <iterator>
#include <list>
#include <stdexcept>
#include <string>

#include "CommandValidator.h"

class CommandParser {
 private:
  int numberOfThreads;
  std::list<std::string> fileNames;

  void parseArguments(const int argc, char** argv);

 public:
  CommandParser(const int argc, char** argv);

  std::list<std::string>& getFileNames();
};