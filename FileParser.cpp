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
  if (!fileHandler.getNextFileOpened(file)) return -1;
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

  return 0;
}

void FileParser::convertGraphConnectionsDictIntoGraph(Graph& graph) {
  graphConnectionsDictionary::iterator dictIt;
  for (dictIt = graphConnections.begin(); dictIt != graphConnections.end();
       ++dictIt) {
    int currentNodeLine = dictIt->first;
    std::vector<int> possibleNextLines = dictIt->second;
    for (int i = 0; i < possibleNextLines.size(); ++i) {
      graph.addEdge(currentNodeLine, possibleNextLines.at(i));
    }
  }
}