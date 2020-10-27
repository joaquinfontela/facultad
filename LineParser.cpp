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

void LineParser::parseLine(std::string& line,
                           graphConnectionsDictionary& graphConnections,
                           labelsLineCallDictionary& labelsLineCallDict) {
  Node newNode(lineNumber);
  std::vector<int> nextLinesList;
  if (line.empty()) {
    return;
  }
  ssize_t labelLength = -1;
  std::string label = "";
  if (hasLabel(line)) {
    labelLength = getLabel(line, label);
    newNode.updateLabel(label);
  }
  std::string instruction = getInstruction(line, labelLength);
  std::string command = getCommand(instruction);
  std::vector<std::string> argumentList = getArgumentList(instruction);
  if (isJumpCommand(command)) {
  } else if (isRetCommand(command)) {
  } else {
  }
  print(&graphConnections);
}

void LineParser::print(graphConnectionsDictionary* graphConnections) {
  graphConnectionsDictionary::iterator it;
  for (it = graphConnections->begin(); it != graphConnections->end(); ++it) {
    Node* currentNode = it->first;
    std::cout << currentNode->getLine() << " | ";
    std::vector<int> nextLines = it->second;
    int i;
    for (i = 0; i < nextLines.size(); i++) {
      std::cout << nextLines.at(i) << " ";
    }
    std::cout << "\n";
  }
}
