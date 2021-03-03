#include <string>

class CommandParser {
 protected:
  std::string port;

 public:
  CommandParser();
  bool commandIsValid(const int argc, char* argv[]);
  std::string getPort() const;
};
