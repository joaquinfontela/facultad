#include "LineParser.h"

LineParser::LineParser(const int lineNumber) {
  this->lineNumber = lineNumber;
  this->jumpInstructions = {"jmp", "ja",  "jeq", "jneq", "jne",
                            "jlt", "jle", "jgt", "jge",  "jset"};
}

bool LineParser::hasLabel(const std::string& line) const {
  return (line.find(":") != std::string::npos);
}

size_t LineParser::getLabel(const std::string& line, std::string& label) const {
  size_t labelLength = line.find(":");
  label = line.substr(0, labelLength);
  return labelLength;
}

void LineParser::checkLabelsLineCallDict(
    graphConnectionsDictionary& graphConnectionsDict,
    const labelsLineCallDictionary& labelsLineCallDict,
    const std::string& label) const {
  if (labelsLineCallDict.find(label) == labelsLineCallDict.end()) return;
  std::set<int> linesWhereLabelWasCalled = labelsLineCallDict.at(label);
  std::set<int>::iterator it;
  for (it = linesWhereLabelWasCalled.begin();
       it != linesWhereLabelWasCalled.end(); ++it) {
    int lineOfCall = (*it);
    graphConnectionsDict.at(lineOfCall).push_back(lineNumber);
  }
}

std::string LineParser::getInstruction(const std::string& line,
                                       const size_t labelLength) const {
  return Trimmer().trim(line.substr(labelLength + 1, line.size()));
}

std::string LineParser::getCommand(const std::string& instruction) const {
  size_t commandLength = instruction.find_first_of(" ");
  return instruction.substr(0, commandLength);
}

std::string LineParser::getArguments(const std::string& instruction) const {
  size_t commandLength = instruction.find_first_of(" ");
  return instruction.substr(commandLength + 1, instruction.size());
}

std::vector<std::string> LineParser::getArgumentList(
    const std::string& instruction) const {
  std::string arguments = getArguments(instruction);
  return StringSplitter().split(arguments, ", ");
}

bool LineParser::isJumpCommand(const std::string& command) const {
  return (this->jumpInstructions.find(command) != this->jumpInstructions.end());
}

bool LineParser::isRetCommand(const std::string& command) const {
  return (!command.compare("ret"));
}

void LineParser::makeNextInstructionNextLine(
    graphConnectionsDictionary& graphConnections) const {
  graphConnections.at(lineNumber).push_back(lineNumber + 1);
}

void LineParser::parseLine(const std::string& line,
                           graphConnectionsDictionary& graphConnections,
                           labelsLineCallDictionary& labelsLineCallDict,
                           lineLabelDictionary& lineLabelDict) const {
  ssize_t labelLength = -1;
  std::string label = "";
  if (hasLabel(line)) {
    labelLength = getLabel(line, label);
    lineLabelDict.insert({lineNumber, label});
    checkLabelsLineCallDict(graphConnections, labelsLineCallDict, label);
  }
  std::string instruction = getInstruction(line, labelLength);
  std::string command = getCommand(instruction);
  std::vector<std::string> argumentList = getArgumentList(instruction);
  if (isJumpCommand(command)) {
    JumpCommandProcessor jumpCommandProcessor(lineNumber, argumentList);
    jumpCommandProcessor.processJump(graphConnections, labelsLineCallDict,
                                     lineLabelDict);
  } else if (!isRetCommand(command)) {
    makeNextInstructionNextLine(graphConnections);
  }
}
