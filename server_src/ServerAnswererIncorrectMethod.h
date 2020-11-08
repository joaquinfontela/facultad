#include "ServerAnswerer.h"

class ServerAnswererIncorrectMethod : public ServerAnswerer {
 public:
  ServerAnswererIncorrectMethod(const HTTPProtocolParser& parser);
  std::string getAnswer(std::map<std::string, std::string>& resources);
};