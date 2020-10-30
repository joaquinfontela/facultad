#ifndef FILE_GRAPH_DATA_H
#define FILE_GRAPH_DATA_H

#include <map>
#include <set>
#include <string>
#include <vector>

#include "Graph.h"

typedef std::map<std::string, std::set<int>> labelsLineCallDictionary;
typedef std::map<int, std::string> lineLabelDictionary;
typedef std::map<int, std::vector<int>> graphConnectionsDictionary;

class FileGraphData {
 private:
  graphConnectionsDictionary graphConnectionsDict;
  labelsLineCallDictionary labelsLineCallDict;
  lineLabelDictionary lineLabelDict;

  bool hasLabelBeenCalled(const std::string& label);
  bool thereIsALabelInLine(int lineNumber);
  void insertNewLineOfLabelCall(const std::string& label,
                                int lineNumberWhereCalled);

 public:
  FileGraphData();

  void reinit();
  void addNewVertex(int lineNumber);
  void createGraph(Graph& graph);
  void checkLabelsLineCallDict(const std::string& label, int currentLineNumber);
  void makeNextInstructionNextLine(int currentLineNumber);
  void addLabelInLine(std::string& label, int lineNumber);
  void processLabel(std::string& label, int currentLineNumber);
  // void printData();
};

#endif
