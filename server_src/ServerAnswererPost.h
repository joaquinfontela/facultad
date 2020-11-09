#include "ServerAnswerer.h"

class ServerAnswererPost : public ServerAnswerer {
 private:
  void updateResources(ResourcesManager& resources);

 public:
  ServerAnswererPost(const HTTPProtocolParser& parser);
  std::string getAnswer(ResourcesManager& resources);
};