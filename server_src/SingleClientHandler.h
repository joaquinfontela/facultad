#include <string>
#include <utility>

#include "ResourcesManager.h"
#include "ServerAnswerer.h"
#include "ServerAnswererFactory.h"
#include "ServerSocket.h"
#include "Thread.h"

class SingleClientHandler : public Thread {
 private:
  bool dead;
  ServerSocket peerSkt;
  HTTPProtocolParser protocolParser;
  ResourcesManager& resourcesManager;

 public:
  SingleClientHandler(ServerSocket&& peer, ResourcesManager& resourcesManager);
  ~SingleClientHandler();
  void run() override;
  bool isDead() const;
};
