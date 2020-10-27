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
    LineParser lineParser(currentLineNumber);
    lineParser.parseLine(line, &graphConnections, &labelsLineCallDict);
    currentLineNumber++;
  }
  fileHandler.closeCurrentFile(file);

  convertGraphConnectionsDictIntoGraph();
  return 0;
}

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
      std::cout << possibleNextLines.size() << "\n";
      currentNode->addNext(getNodeOfLine(possibleNextLines.at(i)));
      std::cout << possibleNextLines.size() << "\n";
    }
  }
}