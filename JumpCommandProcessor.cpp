#include "JumpCommandProcessor.h"

JumpCommandProcessor::JumpCommandProcessor(
    int lineNumber, labelsLineCallDictionary* labelsLineCallDict) {
  this->lineNumber = lineNumber;
  this->labelsLineCallDict = labelsLineCallDict;
}

void JumpCommandProcessor::processJump(
    std::vector<std::string>& argumentList,
    graphConnectionsDictionary* graphConnections, Node* newNode,
    std::vector<int>* nextLinesList) {
  switch (argumentList.size()) {
    case 1:
      processOneArgumentJump(argumentList, graphConnections, newNode,
                             nextLinesList);
      break;

    case 2:
      processTwoArgumentsJump(argumentList, graphConnections, newNode,
                              nextLinesList);
      break;

    case 3:
      processThreeArgumentsJump(argumentList, graphConnections, newNode,
                                nextLinesList);
      break;

    default:
      break;
  }
  graphConnections->insert({newNode, *nextLinesList});
}

std::vector<int> JumpCommandProcessor::getLineCallListOf(std::string& label) {
  if (labelsLineCallDict->find(label) != labelsLineCallDict->end()) {
    return labelsLineCallDict->at(label);
  }
  std::vector<int> newList;
  return std::move(newList);
}

void JumpCommandProcessor::processLabel(
    std::string& label, graphConnectionsDictionary* graphConnections,
    Node* newNode, std::vector<int>* nextLinesList) {
  std::vector<int> lineNumberCallsList = getLineCallListOf(label);
  lineNumberCallsList.push_back(lineNumber);
  labelsLineCallDict->insert({label, lineNumberCallsList});

  graphConnectionsDictionary::iterator it;
  for (it = graphConnections->begin(); it != graphConnections->end(); ++it) {
    Node* currentNode = it->first;
    if (currentNode->getLabel() == label) {
      nextLinesList->push_back(currentNode->getLine());
    }
  }
}

void JumpCommandProcessor::processOneArgumentJump(
    std::vector<std::string>& argumentList,
    graphConnectionsDictionary* graphConnections, Node* newNode,
    std::vector<int>* nextLinesList) {
  processLabel(argumentList.at(0), graphConnections, newNode, nextLinesList);
}

void JumpCommandProcessor::processTwoArgumentsJump(
    std::vector<std::string>& argumentList,
    graphConnectionsDictionary* graphConnections, Node* newNode,
    std::vector<int>* nextLinesList) {
  processLabel(argumentList.at(1), graphConnections, newNode, nextLinesList);
  nextLinesList->push_back(lineNumber + 1);
}

void JumpCommandProcessor::processThreeArgumentsJump(
    std::vector<std::string>& argumentList,
    graphConnectionsDictionary* graphConnections, Node* newNode,
    std::vector<int>* nextLinesList) {
  for (int i = 1; i <= 2; i++) {
    processLabel(argumentList.at(i), graphConnections, newNode, nextLinesList);
  }
}