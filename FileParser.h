#ifndef FILE_PARSER_H
#define FILE_PARSER_H

#include <string>

#include "FileHandler.h"
#include "Graph.h"
#include "LineParser.h"

class FileParser {
 private:
  FileHandler fileHandler;
  FileGraphData fileGraphData;
  int currentLineNumber;

 public:
  explicit FileParser(FileRepository& fileRepository);
  FileParser(const FileParser& copy) = delete;

  void reinit();
  std::string parseNextFile(Graph& graph);
};

#endif
