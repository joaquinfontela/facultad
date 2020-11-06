#include "../common_src/CommandParser.h"

class ServerCommandParser : public CommandParser {
 private:
  std::string filePath;

 public:
  ServerCommandParser();
  bool commandIsValid(int argc, char* argv[]);
  std::string& getFilePath();
};