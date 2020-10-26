#include <stdlib.h>

#include <iostream>
#include <set>
#include <string>

#include "Trimmer.h"

class LineParser {
 private:
  std::set<std::string> jumpInstructions;

 public:
  LineParser();

  bool hasLabel(std::string& line);

  size_t getLabel(std::string& line, std::string& label);

  std::string getInstruction(std::string& line, size_t labelLength);

  bool isJumpInstruction(std::string& instruction);
};