#include "LineParser.h"

LineParser::LineParser(int lineNumber) {
  this->lineNumber = lineNumber;
  this->jumpInstructions = {"jmp", "ja",  "jeq", "jneq", "jne",
                            "jlt", "jle", "jgt", "jge",  "jset"};
}

bool LineParser::hasLabel(std::string& line) {
  return (line.find(":") != std::string::npos);
}

size_t LineParser::getLabel(std::string& line, std::string& label) {
  size_t labelLength = line.find(":");
  label = line.substr(0, labelLength);
  return labelLength;
}

void LineParser::checkLabelsLineCallDict(
    graphConnectionsDictionary& graphConnectionsDict,
    labelsLineCallDictionary& labelsLineCallDict, std::string& label) {
  if (labelsLineCallDict.find(label) == labelsLineCallDict.end()) return;
  std::set<int> linesWhereLabelWasCalled = labelsLineCallDict.at(label);
  std::set<int>::iterator it;
  for (it = linesWhereLabelWasCalled.begin();
       it != linesWhereLabelWasCalled.end(); ++it) {
    int lineOfCall = (*it);
    graphConnectionsDict.at(lineOfCall).insert(lineNumber);
  }
}

std::string LineParser::getInstruction(std::string& line, size_t labelLength) {
  return Trimmer().trim(line.substr(labelLength + 1, line.size()));
}

std::string LineParser::getCommand(std::string& instruction) {
  size_t commandLength = instruction.find_first_of(" ");
  return instruction.substr(0, commandLength);
}

std::string LineParser::getArguments(std::string& instruction) {
  size_t commandLength = instruction.find_first_of(" ");
  return instruction.substr(commandLength + 1, instruction.size());
}

std::vector<std::string> LineParser::getArgumentList(std::string& instruction) {
  std::string arguments = getArguments(instruction);
  return StringSplitter().split(arguments, ", ");
}

bool LineParser::isJumpCommand(std::string& command) {
  return (this->jumpInstructions.find(command) != this->jumpInstructions.end());
}

bool LineParser::isRetCommand(std::string& command) {
  return (!command.compare("ret"));
}

void LineParser::makeNextInstructionNextLine(
    graphConnectionsDictionary& graphConnections, Node& node) {
  graphConnections.at(node.getLine()).insert(lineNumber + 1);
}

void LineParser::parseLine(std::string& line, Node& node,
                           graphConnectionsDictionary& graphConnections,
                           labelsLineCallDictionary& labelsLineCallDict,
                           lineLabelDictionary& lineLabelDict) {
  ssize_t labelLength = -1;
  std::string label = "";
  if (hasLabel(line)) {
    labelLength = getLabel(line, label);
    node.updateLabel(label);
    lineLabelDict.insert({lineNumber, label});
    checkLabelsLineCallDict(graphConnections, labelsLineCallDict, label);
  }
  std::string instruction = getInstruction(line, labelLength);
  std::string command = getCommand(instruction);
  std::vector<std::string> argumentList = getArgumentList(instruction);
  if (isJumpCommand(command)) {
    JumpCommandProcessor jumpCommandProcessor(lineNumber, argumentList);
    jumpCommandProcessor.processJump(graphConnections, node, labelsLineCallDict,
                                     lineLabelDict);
  } else if (!isRetCommand(command)) {
    makeNextInstructionNextLine(graphConnections, node);
  }
  // print(graphConnections);
}

/*
void LineParser::print(graphConnectionsDictionary& graphConnections) {
  graphConnectionsDictionary::iterator it;
  for (it = graphConnections.begin(); it != graphConnections.end(); ++it) {
    int currentNode = it->first;
    std::cout << currentNode << " | ";
    std::vector<int> nextLines = it->second;
    int i;
    for (i = 0; i < nextLines.size(); i++) {
      std::cout << nextLines.at(i) << " ";
    }
    std::cout << "\n";
  }
}
*/
