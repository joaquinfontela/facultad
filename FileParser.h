#include "FileHandler.h"
#include "Graph.h"
#include "LineParser.h"

class FileParser {
 private:
  FileHandler fileHandler;
  int currentLineNumber;
  graphConnectionsDictionary graphConnections;
  labelsLineCallDictionary labelsLineCallDict;
  lineLabelDictionary lineLabelDict;

 public:
  FileParser(FileRepository* fileRepository);
  FileParser(const FileParser& copy) = delete;

  void reinit();
  std::string parseNextFile(Graph& graph);
  void convertGraphConnectionsDictIntoGraph(Graph& graph);
  bool thereAreFilesPending() const;
};