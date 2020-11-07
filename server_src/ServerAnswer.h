#include <set>
#include <string>

#include "HTTPProtocolParser.h"

class ServerAnswer {
 private:
  const HTTPProtocolParser& httpProtocolParser;
  const std::set<std::string> VALID_METHODS;

 public:
  ServerAnswer(const HTTPProtocolParser& httpProtocolParser);
  std::string getAnswer();
};