#include "HTTPProtocolParser.h"
#include "ServerAnswerer.h"

class ServerAnswererFactory {
 public:
  ServerAnswerer* getServerAnswerer(const HTTPProtocolParser& parser);
};