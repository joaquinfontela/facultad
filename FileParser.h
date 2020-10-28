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
  void convertGraphConnectionsDictIntoGraph(Graph& graph);

 public:
  FileParser(FileRepository* fileRepository);
  FileParser(const FileParser& copy) = delete;

  void reinit();
  std::string parseNextFile(Graph& graph);
  bool thereAreFilesPending() const;
};