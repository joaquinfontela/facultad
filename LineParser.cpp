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

void LineParser::addCurrentLineAsNextLineWhereCalled(
    graphConnectionsDictionary* graphConnectionsDictionary,
    int lineWhereCalled) {
  graphConnectionsDictionary::iterator it;
  for (it = graphConnectionsDictionary->begin();
       it != graphConnectionsDictionary->end(); ++it) {
    Node* currentNode = it->first;
    if (currentNode->getLine() == lineWhereCalled) {
      it->second.push_back(this->lineNumber);
    }
  }
}

void LineParser::checkLabelsLineCallDict(
    graphConnectionsDictionary* graphConnectionsDict,
    labelsLineCallDictionary* labelsLineCallDict, std::string& label) {
  std::vector<int> linesWhereLabelWasCalled = labelsLineCallDict->at(label);
  std::vector<int>::iterator it;
  for (it = linesWhereLabelWasCalled.begin();
       it != linesWhereLabelWasCalled.end(); ++it) {
    int lineOfCall = (*it);
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
    graphConnectionsDictionary* graphConnections, Node* node,
    std::vector<int>* nextLinesList) {
  nextLinesList->push_back(lineNumber + 1);
  graphConnections->insert({node, *nextLinesList});
}

void LineParser::processRetInstruction(
    graphConnectionsDictionary* graphConnections, Node* node,
    std::vector<int>* nextLinesList) {
  graphConnections->insert({node, *nextLinesList});
}

void LineParser::parseLine(std::string& line,
                           graphConnectionsDictionary* graphConnections,
                           labelsLineCallDictionary* labelsLineCallDict) {
  Node newNode(lineNumber);
  std::vector<int> nextLinesList;
  if (line.empty()) {
    makeNextInstructionNextLine(graphConnections, &newNode, &nextLinesList);
    return;
  }
  ssize_t labelLength = -1;
  std::string label = "";
  if (hasLabel(line)) {
    labelLength = getLabel(line, label);
    newNode.updateLabel(label);
    checkLabelsLineCallDict(graphConnections, labelsLineCallDict, label);
  }
  std::string instruction = getInstruction(line, labelLength);
  std::string command = getCommand(instruction);
  std::vector<std::string> argumentList = getArgumentList(instruction);
  if (isJumpCommand(command)) {
    JumpCommandProcessor jumpCommandProcessor(lineNumber, labelsLineCallDict);
    jumpCommandProcessor.processJump(argumentList, graphConnections, &newNode,
                                     &nextLinesList);
  } else if (isRetCommand(command)) {
    processRetInstruction(graphConnections, &newNode, &nextLinesList);
  } else {
    makeNextInstructionNextLine(graphConnections, &newNode, &nextLinesList);
  }
}