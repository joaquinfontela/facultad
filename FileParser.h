#include "FileHandler.h"
#include "Graph.h"
#include "LineParser.h"

class FileParser {
 private:
  FileHandler fileHandler;
  FileGraphData fileGraphData;
  int currentLineNumber;

 public:
  FileParser(FileRepository* fileRepository);
  FileParser(const FileParser& copy) = delete;

  void reinit();
  std::string parseNextFile(Graph& graph);
  bool thereAreFilesPending() const;
};