#include "ServerAnswererFactory.h"

#include "ServerAnswererGet.h"
#include "ServerAnswererIncorrectMethod.h"
#include "ServerAnswererPost.h"
#define GET "GET"
#define POST "POST"

ServerAnswerer&& ServerAnswererFactory::getServerAnswerer(
    const HTTPProtocolParser& parser) {
  std::string METHOD = parser.getMethod();

  if (METHOD == GET) {
    return std::move(ServerAnswererGet(parser));
  } else if (METHOD == POST) {
    return std::move(ServerAnswererPost(parser));
  } else {
    return std::move(ServerAnswererIncorrectMethod(parser));
  }
}