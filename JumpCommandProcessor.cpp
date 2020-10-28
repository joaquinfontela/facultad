#include "JumpCommandProcessor.h"

#include <iostream>

JumpCommandProcessor::JumpCommandProcessor(
    int lineNumber, std::vector<std::string>& argumentList) {
  this->lineNumber = lineNumber;
  this->argumentList = argumentList;
}

void JumpCommandProcessor::processJump(
    graphConnectionsDictionary& graphConnections, Node& newNode,
    labelsLineCallDictionary& labelsLineCallDict,
    lineLabelDictionary& lineLabelDict) {
  switch (argumentList.size()) {
    case 1:
      processOneArgumentJump(graphConnections, newNode, labelsLineCallDict,
                             lineLabelDict);
      break;

    case 2:
      processTwoArgumentsJump(graphConnections, newNode, labelsLineCallDict,
                              lineLabelDict);
      break;

    case 3:
      processThreeArgumentsJump(graphConnections, newNode, labelsLineCallDict,
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
    lineLabelDictionary& lineLabelDict, Node& newNode) {
  insertNewLineOfLabelCall(label, labelsLineCallDict);

  printLLCD(labelsLineCallDict);

  graphConnectionsDictionary::iterator it;
  for (it = graphConnections.begin(); it != graphConnections.end(); ++it) {
    int currentNodeLine = it->first;
    if (lineLabelDict.find(currentNodeLine) == lineLabelDict.end()) continue;
    if (lineLabelDict.at(currentNodeLine) == label)
      graphConnections.at(lineNumber).insert(currentNodeLine);
  }
}

void JumpCommandProcessor::processOneArgumentJump(
    graphConnectionsDictionary& graphConnections, Node& newNode,
    labelsLineCallDictionary& labelsLineCallDict,
    lineLabelDictionary& lineLabelDict) {
  processLabel(argumentList.at(0), graphConnections, labelsLineCallDict,
               lineLabelDict, newNode);
}

void JumpCommandProcessor::processTwoArgumentsJump(
    graphConnectionsDictionary& graphConnections, Node& newNode,
    labelsLineCallDictionary& labelsLineCallDict,
    lineLabelDictionary& lineLabelDict) {
  processLabel(argumentList.at(1), graphConnections, labelsLineCallDict,
               lineLabelDict, newNode);
  graphConnections.at(newNode.getLine()).insert(lineNumber + 1);
}

void JumpCommandProcessor::processThreeArgumentsJump(
    graphConnectionsDictionary& graphConnections, Node& newNode,
    labelsLineCallDictionary& labelsLineCallDict,
    lineLabelDictionary& lineLabelDict) {
  for (int i = 1; i <= 2; i++) {
    processLabel(argumentList.at(i), graphConnections, labelsLineCallDict,
                 lineLabelDict, newNode);
  }
}