#include <string>
#include <vector>

#include "FileGraphData.h"

class JumpCommandProcessor {
 private:
  int lineNumber;
  std::vector<std::string> argumentList;

  void processOneArgumentJump(FileGraphData& fileGraphData);

  void processTwoArgumentsJump(FileGraphData& fileGraphData);

  void processThreeArgumentsJump(FileGraphData& fileGraphData);

 public:
  JumpCommandProcessor(int lineNumber, std::vector<std::string>& argumentList);

  void processJump(FileGraphData& fileGraphData);
};
