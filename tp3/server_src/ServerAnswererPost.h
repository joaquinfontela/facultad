#include <string>

#include "ServerAnswerer.h"

class ServerAnswererPost : public ServerAnswerer {
 private:
  void updateResources(ResourcesManager& resources) const;

 public:
  explicit ServerAnswererPost(const HTTPProtocolParser& parser);
  ~ServerAnswererPost();
  std::string getAnswer(ResourcesManager& resources) const override;
};
