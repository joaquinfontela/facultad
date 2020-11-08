#include "ServerAnswerer.h"

class ServerAnswererPost : public ServerAnswerer {
 public:
  ServerAnswererPost(const HTTPProtocolParser& parser);
  std::string getAnswer(std::map<std::string, std::string>& resources);
};