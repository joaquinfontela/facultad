#include "ServerAnswerer.h"

class ServerAnswererGet : public ServerAnswerer {
 public:
  ServerAnswererGet(const HTTPProtocolParser& parser);
  ~ServerAnswererGet();
  std::string getAnswer(ResourcesManager& resources);
};