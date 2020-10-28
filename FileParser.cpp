#include "FileParser.h"

#include <errno.h>
#include <string.h>

FileParser::FileParser(FileRepository* fileRepository)
    : fileHandler(fileRepository) {}

void FileParser::reinit() {
  currentLineNumber = 1;
  graphConnections.clear();
  labelsLineCallDict.clear();
  lineLabelDict.clear();
}

std::string FileParser::parseNextFile(Graph& graph) {
  std::ifstream file;
  std::string line;
  if (!fileHandler.getNextFileOpened(file)) return "";
  while (getline(file, line)) {
    if (line.empty()) continue;

    LineParser lineParser(currentLineNumber);
    graph.addVertex(currentLineNumber);
    std::vector<int> possibleNextLines;
    graphConnections.insert({currentLineNumber, std::move(possibleNextLines)});

    lineParser.parseLine(line, graphConnections, labelsLineCallDict,
                         lineLabelDict);
    currentLineNumber++;
  }
  fileHandler.closeCurrentFile(file);
  convertGraphConnectionsDictIntoGraph(graph);

  return fileHandler.getNameOfLastFileOpened();
}

void FileParser::convertGraphConnectionsDictIntoGraph(Graph& graph) {
  graphConnectionsDictionary::iterator dictIt;
  for (dictIt = graphConnections.begin(); dictIt != graphConnections.end();
       ++dictIt) {
    int currentNodeLine = dictIt->first;
    std::vector<int> possibleNextLines = dictIt->second;
    for (unsigned int i = 0; i < possibleNextLines.size(); ++i) {
      graph.addEdge(currentNodeLine, possibleNextLines.at(i));
    }
  }
}

bool FileParser::thereAreFilesPending() const {
  return fileHandler.thereAreFilesPending();
}