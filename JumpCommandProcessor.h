#include <map>
#include <string>
#include <vector>

#include "Node.h"

typedef std::map<std::string, std::vector<int>> labelsLineCallDictionary;
typedef std::map<Node*, std::vector<int>> graphConnectionsDictionary;

class JumpCommandProcessor {
 private:
  int lineNumber;
  labelsLineCallDictionary* labelsLineCallDict;

  std::vector<int> getLineCallListOf(std::string& label);

  void processLabel(std::string& label,
                    graphConnectionsDictionary* graphConnections, Node* newNode,
                    std::vector<int>* nextLinesList);

  void processOneArgumentJump(std::vector<std::string>& argumentList,
                              graphConnectionsDictionary* graphConnections,
                              Node* newNode, std::vector<int>* nextLinesList);
  void processTwoArgumentsJump(std::vector<std::string>& argumentList,
                               graphConnectionsDictionary* graphConnections,
                               Node* newNode, std::vector<int>* nextLinesList);
  void processThreeArgumentsJump(std::vector<std::string>& argumentList,
                                 graphConnectionsDictionary* graphConnections,
                                 Node* newNode,
                                 std::vector<int>* nextLinesList);

 public:
  JumpCommandProcessor(int lineNumber,
                       labelsLineCallDictionary* labelsLineCallDict);

  void processJump(std::vector<std::string>& argumentList,
                   graphConnectionsDictionary* graphConnections, Node* newNode,
                   std::vector<int>* nextLinesList);
};