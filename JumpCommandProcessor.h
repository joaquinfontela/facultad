#include <map>
#include <set>
#include <string>
#include <vector>

typedef std::map<std::string, std::set<int>> labelsLineCallDictionary;
typedef std::map<int, std::string> lineLabelDictionary;
typedef std::map<int, std::vector<int>> graphConnectionsDictionary;

class JumpCommandProcessor {
 private:
  int lineNumber;
  std::vector<std::string> argumentList;

  void insertNewLineOfLabelCall(
      std::string& label, labelsLineCallDictionary& labelsLineCallDict) const;

  void processLabel(std::string label,
                    graphConnectionsDictionary& graphConnections,
                    labelsLineCallDictionary& labelsLineCallDict,
                    const lineLabelDictionary& lineLabelDict) const;

  void processOneArgumentJump(graphConnectionsDictionary& graphConnections,
                              labelsLineCallDictionary& labelsLineCallDict,
                              const lineLabelDictionary& lineLabelDict) const;

  void processTwoArgumentsJump(graphConnectionsDictionary& graphConnections,
                               labelsLineCallDictionary& labelsLineCallDict,
                               const lineLabelDictionary& lineLabelDict) const;

  void processThreeArgumentsJump(
      graphConnectionsDictionary& graphConnections,
      labelsLineCallDictionary& labelsLineCallDict,
      const lineLabelDictionary& lineLabelDict) const;

 public:
  JumpCommandProcessor(int lineNumber, std::vector<std::string>& argumentList);

  void processJump(graphConnectionsDictionary& graphConnections,
                   labelsLineCallDictionary& labelsLineCallDict,
                   const lineLabelDictionary& lineLabelDict) const;
};