#include "FileHandler.h"
#include "Graph.h"
#include "LineParser.h"

class FileParser {
 private:
  Graph fileGraph;
  FileHandler fileHandler;
  bool getNextFileOpened(std::ifstream& nextFile);
  void closeCurrentFile(std::ifstream& file);
  void parseLine(std::string& line);

 public:
  FileParser(FileRepository* fileRepository);
  int parseNextFile(Graph& graph);
};