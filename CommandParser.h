#include <bits/stdc++.h>

#include <iterator>
#include <stdexcept>
#include <string>
#include <vector>

#include "CommandValidator.h"

class CommandParser {
 private:
  int numberOfThreads;
  std::vector<std::string> fileNames;

  void parseArguments(const int argc, char** argv);

 public:
  CommandParser(const int argc, char** argv);
  CommandParser(const CommandParser& copy) = delete;

  std::vector<std::string>& getFileNames();
};