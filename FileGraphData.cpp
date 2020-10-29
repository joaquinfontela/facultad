#include "FileGraphData.h"

#include "Trimmer.h"

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

void FileGraphData::processLabel(std::string& label, int currentLineNumber) {
  label = Trimmer().trim(label);
  insertNewLineOfLabelCall(label, currentLineNumber);

  graphConnectionsDictionary::iterator it;
  for (it = graphConnectionsDict.begin(); it != graphConnectionsDict.end();
       ++it) {
    int currentNodeLine = it->first;
    if (!thereIsALabelInLine(currentNodeLine)) continue;
    if (lineLabelDict.at(currentNodeLine) ==
        label)  // aca busco la linea donde se define el label
      graphConnectionsDict.at(currentLineNumber).push_back(currentNodeLine);
  }
}

/*
void FileGraphData::printData() {
  std::cout << "Graph connections\n";
  for (auto dictIt : graphConnectionsDict) {
    int currentNode = dictIt.first;
    std::cout << currentNode << ": ";
    std::vector<int> possibleNextLines = dictIt.second;
    for (auto listIt : possibleNextLines) {
      std::cout << listIt << "  ";
    }
    std::cout << "\n";
  }

  std::cout << "\nLabelLineCall Dict\n";
  for (auto dictIt : labelsLineCallDict) {
    std::string currentLabel = dictIt.first;
    std::cout << currentLabel << ": ";
    std::set<int> linesWhereCalled = dictIt.second;
    for (auto setIt : linesWhereCalled) {
      std::cout << setIt << "  ";
    }
    std::cout << "\n";
  }

  std::cout << "\nLineLabelDict\n";
  for (auto dictIt : lineLabelDict) {
    std::cout << dictIt.first << ": " << dictIt.second << "\n";
  }

  std::cout << "\n\n\n\n";
}
*/
