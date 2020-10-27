#include <stdlib.h>

#include <iostream>
#include <map>
#include <set>
#include <string>
#include <vector>

#include "Node.h"
#include "StringSplitter.h"
#include "Trimmer.h"

typedef std::map<std::string, std::vector<int>> labelsLineCallDictionary;
typedef std::map<Node*, std::vector<int>> graphConnectionsDictionary;

class LineParser {
 private:
  std::set<std::string> jumpInstructions;
  int lineNumber;

  bool hasLabel(std::string& line);
  size_t getLabel(std::string& line, std::string& label);
  std::string getInstruction(std::string& line, size_t labelLength);
  std::string getCommand(std::string& instruction);
  std::string getArguments(std::string& instruction);
  std::vector<std::string> getArgumentList(std::string& instruction);
  bool isJumpCommand(std::string& command);
  bool isRetCommand(std::string& command);
  void print(graphConnectionsDictionary* graphConnections);

 public:
  LineParser(int lineNumber);
  LineParser(const LineParser& copy) = delete;

  void parseLine(std::string& line,
                 graphConnectionsDictionary& graphConnections,
                 labelsLineCallDictionary& labelsLineCallDict);
};