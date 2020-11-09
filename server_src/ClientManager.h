#include "Thread.h"

class ClientManager : public Thread {
 public:
  ClientManager();
  void run();
};