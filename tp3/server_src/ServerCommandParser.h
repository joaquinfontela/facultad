#include <string>

#include "../common_src/CommandParser.h"

class ServerCommandParser : public CommandParser {
 private:
  std::string filePath;

 public:
  ServerCommandParser();
  bool commandIsValid(const int argc, char* argv[]);
  std::string getFilePath() const;
};
