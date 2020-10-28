#include "FileGraphData.h"

class JumpCommandProcessor {
 private:
  int lineNumber;
  std::vector<std::string> argumentList;

  void processOneArgumentJump(FileGraphData& fileGraphData) const;

  void processTwoArgumentsJump(FileGraphData& fileGraphData) const;

  void processThreeArgumentsJump(FileGraphData& fileGraphData) const;

 public:
  JumpCommandProcessor(int lineNumber, std::vector<std::string>& argumentList);

  void processJump(FileGraphData& fileGraphData) const;
};