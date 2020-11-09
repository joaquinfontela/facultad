#include "ClientManager.h"
#include "FileReader.h"
#include "ResourcesManager.h"
#include "ServerCommandParser.h"

class Server {
 private:
  const std::string PORT;
  ResourcesManager resourcesManager;

 public:
  Server(const ServerCommandParser& commandParser);
  void run();
};