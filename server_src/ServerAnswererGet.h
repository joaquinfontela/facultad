#include <string>

#include "ServerAnswerer.h"

class ServerAnswererGet : public ServerAnswerer {
 public:
  explicit ServerAnswererGet(const HTTPProtocolParser& parser);
  ~ServerAnswererGet();
  std::string getAnswer(ResourcesManager& resources) const override;
};
