#include <list>

#include "HTTPProtocolParser.h"
#include "SingleClientHandler.h"

typedef std::list<SingleClientHandler*>::iterator clientHandlersIterator;

class ClientManager : public Thread {
 private:
  ServerSocket serverSkt;
  std::list<SingleClientHandler*> clientHandlers;
  ResourcesManager& resourcesManager;

 public:
  ClientManager(const std::string& port, ResourcesManager& resourcesManager);
  ~ClientManager();
  void run();
  void clientCleaner();
};