#include <string>

#include "ServerAnswerer.h"

class ServerAnswererIncorrectMethod : public ServerAnswerer {
 public:
  explicit ServerAnswererIncorrectMethod(const HTTPProtocolParser& parser);
  ~ServerAnswererIncorrectMethod();
  std::string getAnswer(ResourcesManager& resources) const override;
};
