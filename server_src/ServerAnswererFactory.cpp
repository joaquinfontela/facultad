#include "ServerAnswererFactory.h"

#include "ServerAnswererGet.h"
#include "ServerAnswererIncorrectMethod.h"
#include "ServerAnswererPost.h"
#define GET "GET"
#define POST "POST"

ServerAnswerer* ServerAnswererFactory::getServerAnswerer(
    const HTTPProtocolParser& parser) {
  std::string METHOD = parser.getMethod();

  if (METHOD == GET) {
    return new ServerAnswererGet(parser);
  } else if (METHOD == POST) {
    return new ServerAnswererPost(parser);
  } else {
    return new ServerAnswererIncorrectMethod(parser);
  }
}