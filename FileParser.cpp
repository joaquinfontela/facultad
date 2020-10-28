#include "FileParser.h"

#include <errno.h>
#include <string.h>

FileParser::FileParser(FileRepository* fileRepository)
    : fileHandler(fileRepository) {
  currentLineNumber = 1;
}

int FileParser::parseNextFile(Graph& graph) {
  std::ifstream file;
  std::string line;
  this->fileGraph = graph;
  if (!fileHandler.getNextFileOpened(file)) return -1;
  while (getline(file, line)) {
    if (line.empty()) continue;

    LineParser lineParser(currentLineNumber);
    Node newNode(currentLineNumber);
    std::set<int> possibleNextLines;
    graphConnections.insert({newNode.getLine(), possibleNextLines});

    lineParser.parseLine(line, newNode, graphConnections, labelsLineCallDict,
                         lineLabelDict);
    currentLineNumber++;
  }
  print(graphConnections);
  fileHandler.closeCurrentFile(file);

  return 0;
}

void FileParser::print(graphConnectionsDictionary& graphConnections) {
  graphConnectionsDictionary::iterator it;
  for (it = graphConnections.begin(); it != graphConnections.end(); ++it) {
    int currentNode = it->first;
    std::cout << currentNode << " | ";
    std::set<int> nextLines = it->second;
    std::set<int>::iterator it;
    for (it = nextLines.begin(); it != nextLines.end(); ++it) {
      std::cout << (*it) << " ";
    }
    std::cout << "\n";
  }
}

/*
Node* FileParser::getNodeOfLine(int line) {
  graphConnectionsDictionary::iterator it;
  for (it = graphConnections.begin(); it != graphConnections.end(); ++it) {
    Node* currentNode = it->first;
    if (currentNode->getLine() == line) {
      return currentNode;
    }
  }
  return NULL;
}

void FileParser::convertGraphConnectionsDictIntoGraph() {
  graphConnectionsDictionary::iterator dictIt;
  for (dictIt = graphConnections.begin(); dictIt != graphConnections.end();
       ++dictIt) {
    Node* currentNode = dictIt->first;
    this->fileGraph.addVertex(currentNode);
    std::vector<int> possibleNextLines = dictIt->second;
    int i;
    for (i = 0; i < possibleNextLines.size(); i++) {
      currentNode->addNext(getNodeOfLine(possibleNextLines.at(i)));
    }
  }
}
*/