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

  bool hasLabel(std::string& line) const;
  size_t getLabel(std::string& line, std::string& label) const;
  void checkLabelsLineCallDict(graphConnectionsDictionary& graphConnectionsDict,
                               labelsLineCallDictionary& labelsLineCallDict,
                               std::string& label) const;
  std::string getInstruction(std::string& line, size_t labelLength) const;
  std::string getCommand(std::string& instruction) const;
  std::string getArguments(std::string& instruction) const;
  std::vector<std::string> getArgumentList(std::string& instruction) const;
  bool isJumpCommand(std::string& command) const;
  bool isRetCommand(std::string& command) const;
  void makeNextInstructionNextLine(
      graphConnectionsDictionary& graphConnections) const;

 public:
  LineParser(int lineNumber);
  LineParser(const LineParser& copy) = delete;

  void parseLine(std::string& line,
                 graphConnectionsDictionary& graphConnections,
                 labelsLineCallDictionary& labelsLineCallDict,
                 lineLabelDictionary& lineLabelDict) const;
};