#include <string>

#include "ServerAnswerer.h"

class ServerAnswererPost : public ServerAnswerer {
 private:
  void updateResources(ResourcesManager& resources);

 public:
  explicit ServerAnswererPost(const HTTPProtocolParser& parser);
  ~ServerAnswererPost();
  std::string getAnswer(ResourcesManager& resources) override;
};
