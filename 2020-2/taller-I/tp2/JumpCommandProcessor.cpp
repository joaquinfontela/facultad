#include "JumpCommandProcessor.h"

#include <iostream>

JumpCommandProcessor::JumpCommandProcessor(
    int lineNumber, const std::vector<std::string>& argumentList) {
  this->lineNumber = lineNumber;
  this->argumentList = argumentList;
}

// Me pide que fileGraphData sea const pero lo necesito modificar.
// cppcheck-suppress constParameter
void JumpCommandProcessor::processJump(FileGraphData& fileGraphData) {
  switch (argumentList.size()) {
    case 1:
      processOneArgumentJump(fileGraphData);
      break;

    case 2:
      processTwoArgumentsJump(fileGraphData);
      break;

    case 3:
      processThreeArgumentsJump(fileGraphData);
      break;

    default:
      break;
  }
}

void JumpCommandProcessor::processOneArgumentJump(
    FileGraphData& fileGraphData) {
  fileGraphData.processLabel(argumentList.at(0), lineNumber);
}

void JumpCommandProcessor::processTwoArgumentsJump(
    FileGraphData& fileGraphData) {
  fileGraphData.processLabel(argumentList.at(1), lineNumber);
  fileGraphData.makeNextInstructionNextLine(lineNumber);
}

void JumpCommandProcessor::processThreeArgumentsJump(
    FileGraphData& fileGraphData) {
  for (int i = 1; i <= 2; i++) {
    fileGraphData.processLabel(argumentList.at(i), lineNumber);
  }
}
