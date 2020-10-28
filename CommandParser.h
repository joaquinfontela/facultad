#include <iterator>
#include <queue>
#include <stdexcept>
#include <string>

#include "CommandValidator.h"

class CommandParser {
 private:
  int numberOfThreads;
  std::queue<std::string> fileNames;

  void parseArguments(const int argc, char** argv);

 public:
  CommandParser(const int argc, char** argv);
  CommandParser(const CommandParser& copy) = delete;

  std::queue<std::string>& getFileNames();
};