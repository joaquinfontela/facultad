#include "FileGraphData.h"

FileGraphData::FileGraphData() {}

void FileGraphData::reinit() {
  graphConnectionsDict.clear();
  labelsLineCallDict.clear();
  lineLabelDict.clear();
}

bool FileGraphData::hasLabelBeenCalled(const std::string& label) {
  return (labelsLineCallDict.find(label) != labelsLineCallDict.end());
}

bool FileGraphData::thereIsALabelInLine(int lineNumber) {
  return (lineLabelDict.find(lineNumber) != lineLabelDict.end());
}

void FileGraphData::insertNewLineOfLabelCall(const std::string& label,
                                             int lineNumberWhereCalled) {
  if (hasLabelBeenCalled(label)) {
    labelsLineCallDict.at(label).insert(lineNumberWhereCalled);
  } else {
    std::set<int> newSet;
    newSet.insert(lineNumberWhereCalled);
    labelsLineCallDict.insert({label, newSet});
  }
}

void FileGraphData::addNewVertex(int lineNumber) {
  std::vector<int> possibleNextLines;
  graphConnectionsDict.insert({lineNumber, std::move(possibleNextLines)});
}

void FileGraphData::createGraph(Graph& graph) {
  graphConnectionsDictionary::iterator dictIt;
  for (dictIt = graphConnectionsDict.begin();
       dictIt != graphConnectionsDict.end(); ++dictIt) {
    int currentNodeLine = dictIt->first;
    std::vector<int> possibleNextLines = dictIt->second;
    for (unsigned int i = 0; i < possibleNextLines.size(); ++i) {
      graph.addEdge(currentNodeLine, possibleNextLines.at(i));
    }
  }
}

void FileGraphData::checkLabelsLineCallDict(const std::string& label,
                                            int currentLineNumber) {
  if (!hasLabelBeenCalled(label)) return;
  std::set<int> linesWhereLabelWasCalled = labelsLineCallDict.at(label);
  std::set<int>::iterator it;
  for (it = linesWhereLabelWasCalled.begin();
       it != linesWhereLabelWasCalled.end(); ++it) {
    int lineOfCall = (*it);
    graphConnectionsDict.at(lineOfCall).push_back(currentLineNumber);
  }
}

void FileGraphData::makeNextInstructionNextLine(int lineNumber) {
  graphConnectionsDict.at(lineNumber).push_back(lineNumber + 1);
}

void FileGraphData::addLabelInLine(std::string& label, int lineNumber) {
  lineLabelDict.insert({lineNumber, label});
}

void FileGraphData::processLabel(const std::string& label,
                                 int currentLineNumber) {
  insertNewLineOfLabelCall(label, currentLineNumber);

  graphConnectionsDictionary::iterator it;
  for (it = graphConnectionsDict.begin(); it != graphConnectionsDict.end();
       ++it) {
    int currentNodeLine = it->first;
    if (!thereIsALabelInLine(currentNodeLine)) continue;
    if (lineLabelDict.at(currentNodeLine) == label)
      graphConnectionsDict.at(currentLineNumber).push_back(currentNodeLine);
  }
}
