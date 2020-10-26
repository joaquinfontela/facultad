#include "FileParser.h"

#include <errno.h>
#include <string.h>

FileParser::FileParser(FileRepository* fileRepository)
    : fileHandler(fileRepository) {}

void FileParser::parseLine(std::string& line) {
  if (line.empty()) return;
  LineParser lineParser;
  ssize_t labelLength = -1;
  std::string label = "";
  if (lineParser.hasLabel(line)) {
    labelLength = lineParser.getLabel(line, label);
  }
  std::string instruction = lineParser.getInstruction(line, labelLength);
  lineParser.isJumpInstruction(instruction);
}

int FileParser::parseNextFile(Graph& graph) {
  std::ifstream file;
  std::string line;
  this->fileGraph = graph;
  if (!fileHandler.getNextFileOpened(file)) return -1;
  while (getline(file, line)) {
    parseLine(line);
  }
  fileHandler.closeCurrentFile(file);
}