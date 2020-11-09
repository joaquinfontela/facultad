#include "HTTPProtocolParser.h"
#include "ResourcesManager.h"
#include "ServerAnswerer.h"
#include "ServerAnswererFactory.h"
#include "ServerSocket.h"
#include "Thread.h"

class ClientManager : public Thread {
 private:
  ServerSocket serverSkt;
  HTTPProtocolParser protocolParser;
  ResourcesManager resourcesManager;

 public:
  ClientManager(const std::string& port, ResourcesManager& resourcesManager);
  void run();
};