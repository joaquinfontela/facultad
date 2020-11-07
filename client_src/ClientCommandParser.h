#include "../common_src/CommandParser.h"

class ClientCommandParser : public CommandParser {
 private:
  std::string host;

 public:
  ClientCommandParser();
  bool commandIsValid(const int argc, char* argv[]);
  std::string getHost();
};