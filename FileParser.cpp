#include "FileParser.h"

#include <errno.h>

#include <string>

// Me pide que fileRepository sea const pero lo necesito modificar por dentro.
// cppcheck-suppress constParameter
FileParser::FileParser(FileRepository& fileRepository)
    : fileHandler(fileRepository) {
  currentLineNumber = 1;
}

void FileParser::reinit() {
  currentLineNumber = 1;
  fileGraphData.reinit();
}

std::string FileParser::parseNextFile(Graph& graph) {
  std::ifstream file;
  std::string line;
  if (!fileHandler.getNextFileOpened(file)) return "";
  while (getline(file, line)) {
    if (line.empty()) continue;

    LineParser lineParser(currentLineNumber);
    graph.addVertex(currentLineNumber);
    fileGraphData.addNewVertex(currentLineNumber);

    lineParser.parseLine(line, fileGraphData);
    currentLineNumber++;
  }
  fileHandler.closeCurrentFile(file);
  fileGraphData.createGraph(graph);

  return fileHandler.getNameOfLastFileOpened();
}
