#include "FileHandler.h"
#include "Graph.h"
#include "LineParser.h"

class FileParser {
 private:
  Graph fileGraph;
  FileHandler fileHandler;
  int currentLineNumber;
  graphConnectionsDictionary graphConnections;
  labelsLineCallDictionary labelsLineCallDict;
  lineLabelDictionary lineLabelDict;

  Node* getNodeOfLine(int line);
  void print(graphConnectionsDictionary& graphConnections);

 public:
  FileParser(FileRepository* fileRepository);
  FileParser(const FileParser& copy) = delete;

  int parseNextFile(Graph& graph);
  // void convertGraphConnectionsDictIntoGraph();
};