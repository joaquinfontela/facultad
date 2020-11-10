#include "ServerAnswerer.h"

class ServerAnswererIncorrectMethod : public ServerAnswerer {
 public:
  ServerAnswererIncorrectMethod(const HTTPProtocolParser& parser);
  ~ServerAnswererIncorrectMethod();
  std::string getAnswer(ResourcesManager& resources);
};