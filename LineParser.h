#include <stdlib.h>

#include <iostream>
#include <map>
#include <set>

#include "JumpCommandProcessor.h"
#include "StringSplitter.h"
#include "Trimmer.h"

class LineParser {
 private:
  std::set<std::string> jumpInstructions;
  int lineNumber;

  bool hasLabel(std::string& line);
  size_t getLabel(std::string& line, std::string& label);
  void addCurrentLineAsNextLineWhereCalled(
      graphConnectionsDictionary* graphConnectionsDictionary,
      int lineWhereCalled);
  void checkLabelsLineCallDict(graphConnectionsDictionary* graphConnectionsDict,
                               labelsLineCallDictionary* labelsLineCallDict,
                               std::string& label);
  std::string getInstruction(std::string& line, size_t labelLength);
  std::string getCommand(std::string& instruction);
  std::string getArguments(std::string& instruction);
  std::vector<std::string> getArgumentList(std::string& instruction);
  bool isJumpCommand(std::string& command);
  bool isRetCommand(std::string& command);
  void makeNextInstructionNextLine(graphConnectionsDictionary* graphConnections,
                                   Node* node, std::vector<int>* nextLinesList);
  void processRetInstruction(graphConnectionsDictionary* graphConnections,
                             Node* node, std::vector<int>* nextLinesList);

 public:
  LineParser(int lineNumber);
  LineParser(const LineParser& copy) = delete;

  void parseLine(std::string& line,
                 graphConnectionsDictionary* graphConnections,
                 labelsLineCallDictionary* labelsLineCallDict);
};