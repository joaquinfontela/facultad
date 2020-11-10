#include "ServerAnswerer.h"

class ServerAnswererPost : public ServerAnswerer {
 private:
  void updateResources(ResourcesManager& resources);

 public:
  ServerAnswererPost(const HTTPProtocolParser& parser);
  ~ServerAnswererPost();
  std::string getAnswer(ResourcesManager& resources);
};