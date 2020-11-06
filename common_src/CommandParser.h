#include <string>

class CommandParser {
 protected:
  std::string port;

 public:
  CommandParser();
  bool commandIsValid(int argc, char* argv[]);
  std::string& getPort();
};