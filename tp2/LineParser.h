#include <stdlib.h>

#include <iostream>
#include <map>
#include <set>
#include <string>
#include <vector>

#include "JumpCommandProcessor.h"
#include "StringSplitter.h"
#include "Trimmer.h"

class LineParser {
 private:
  std::set<std::string> jumpInstructions;
  int lineNumber;

  bool hasLabel(const std::string& line) const;
  size_t getLabel(const std::string& line, std::string& label) const;
  std::string getInstruction(const std::string& line,
                             const size_t labelLength) const;
  std::string getCommand(const std::string& instruction) const;
  std::string getArguments(const std::string& instruction) const;
  std::vector<std::string> getArgumentList(
      const std::string& instruction) const;
  bool isJumpCommand(const std::string& command) const;
  bool isRetCommand(const std::string& command) const;

 public:
  explicit LineParser(const int lineNumber);
  LineParser(const LineParser& copy) = delete;

  void parseLine(const std::string& line, FileGraphData& fileGraphData) const;
};
