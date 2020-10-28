#include "JumpCommandProcessor.h"

#include <iostream>

JumpCommandProcessor::JumpCommandProcessor(
    int lineNumber, std::vector<std::string>& argumentList) {
  this->lineNumber = lineNumber;
  this->argumentList = argumentList;
}

void JumpCommandProcessor::processJump(
    graphConnectionsDictionary& graphConnections,
    labelsLineCallDictionary& labelsLineCallDict,
    lineLabelDictionary& lineLabelDict) {
  switch (argumentList.size()) {
    case 1:
      processOneArgumentJump(graphConnections, labelsLineCallDict,
                             lineLabelDict);
      break;

    case 2:
      processTwoArgumentsJump(graphConnections, labelsLineCallDict,
                              lineLabelDict);
      break;

    case 3:
      processThreeArgumentsJump(graphConnections, labelsLineCallDict,
                                lineLabelDict);
      break;

    default:
      break;
  }
}

void JumpCommandProcessor::insertNewLineOfLabelCall(
    std::string& label, labelsLineCallDictionary& labelsLineCallDict) {
  if (labelsLineCallDict.find(label) != labelsLineCallDict.end()) {
    labelsLineCallDict.at(label).insert(lineNumber);
  } else {
    std::set<int> newSet;
    newSet.insert(lineNumber);
    labelsLineCallDict.insert({label, newSet});
  }
}

void JumpCommandProcessor::processLabel(
    std::string& label, graphConnectionsDictionary& graphConnections,
    labelsLineCallDictionary& labelsLineCallDict,
    lineLabelDictionary& lineLabelDict) {
  insertNewLineOfLabelCall(label, labelsLineCallDict);

  graphConnectionsDictionary::iterator it;
  for (it = graphConnections.begin(); it != graphConnections.end(); ++it) {
    int currentNodeLine = it->first;
    if (lineLabelDict.find(currentNodeLine) == lineLabelDict.end()) continue;
    if (lineLabelDict.at(currentNodeLine) == label)
      graphConnections.at(lineNumber).push_back(currentNodeLine);
  }
}

void JumpCommandProcessor::processOneArgumentJump(
    graphConnectionsDictionary& graphConnections,
    labelsLineCallDictionary& labelsLineCallDict,
    lineLabelDictionary& lineLabelDict) {
  processLabel(argumentList.at(0), graphConnections, labelsLineCallDict,
               lineLabelDict);
}

void JumpCommandProcessor::processTwoArgumentsJump(
    graphConnectionsDictionary& graphConnections,
    labelsLineCallDictionary& labelsLineCallDict,
    lineLabelDictionary& lineLabelDict) {
  processLabel(argumentList.at(1), graphConnections, labelsLineCallDict,
               lineLabelDict);
  graphConnections.at(lineNumber).push_back(lineNumber + 1);
}

void JumpCommandProcessor::processThreeArgumentsJump(
    graphConnectionsDictionary& graphConnections,
    labelsLineCallDictionary& labelsLineCallDict,
    lineLabelDictionary& lineLabelDict) {
  for (int i = 1; i <= 2; i++) {
    processLabel(argumentList.at(i), graphConnections, labelsLineCallDict,
                 lineLabelDict);
  }
}