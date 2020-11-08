#include "ServerAnswerer.h"

class ServerAnswererGet : public ServerAnswerer {
 public:
  ServerAnswererGet(const HTTPProtocolParser& parser);
  std::string getAnswer(std::map<std::string, std::string>& resources);
};