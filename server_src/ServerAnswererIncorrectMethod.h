#include "ServerAnswerer.h"

class ServerAnswererIncorrectMethod : public ServerAnswerer {
 public:
  ServerAnswererIncorrectMethod(const HTTPProtocolParser& parser);
  std::string getAnswer(ResourcesManager& resources);
};