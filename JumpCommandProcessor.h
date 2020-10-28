#include <map>
#include <set>
#include <string>
#include <vector>

#include "Node.h"

typedef std::map<std::string, std::set<int>> labelsLineCallDictionary;
typedef std::map<int, std::string> lineLabelDictionary;
typedef std::map<int, std::set<int>> graphConnectionsDictionary;

class JumpCommandProcessor {
 private:
  int lineNumber;
  std::vector<std::string> argumentList;

  void insertNewLineOfLabelCall(std::string& label,
                                labelsLineCallDictionary& labelsLineCallDict);

  void processLabel(std::string& label,
                    graphConnectionsDictionary& graphConnections,
                    labelsLineCallDictionary& labelsLineCallDict,
                    lineLabelDictionary& lineLabelDict, Node& newNode);

  void processOneArgumentJump(graphConnectionsDictionary& graphConnections,
                              Node& newNode,
                              labelsLineCallDictionary& labelsLineCallDict,
                              lineLabelDictionary& lineLabelDict);

  void processTwoArgumentsJump(graphConnectionsDictionary& graphConnections,
                               Node& newNode,
                               labelsLineCallDictionary& labelsLineCallDict,
                               lineLabelDictionary& lineLabelDict);

  void processThreeArgumentsJump(graphConnectionsDictionary& graphConnections,
                                 Node& newNode,
                                 labelsLineCallDictionary& labelsLineCallDict,
                                 lineLabelDictionary& lineLabelDict);

 public:
  JumpCommandProcessor(int lineNumber, std::vector<std::string>& argumentList);

  void processJump(graphConnectionsDictionary& graphConnections, Node& newNode,
                   labelsLineCallDictionary& labelsLineCallDict,
                   lineLabelDictionary& lineLabelDict);
};