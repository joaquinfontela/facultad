#include "ServerAnswerer.h"

class ServerAnswererGet : public ServerAnswerer {
 public:
  ServerAnswererGet(const HTTPProtocolParser& parser);
  std::string getAnswer(ResourcesManager& resources);
};