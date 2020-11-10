#include "ServerAnswererGet.h"

#define ROOT_FILE "/"

ServerAnswererGet::ServerAnswererGet(const HTTPProtocolParser& parser)
    : ServerAnswerer(parser) {}

ServerAnswererGet::~ServerAnswererGet() {}

std::string ServerAnswererGet::getAnswer(ResourcesManager& resources) {
  std::string resource = httpProtocolParser.getResource();
  if (!resources.hasResource(resource)) {
    return "HTTP/1.1 404 NOT FOUND\n\n";
  }
  std::string answer;
  if (resource == ROOT_FILE) {
    answer += "HTTP/1.1 200 OK\nContent-Type: text/html\n\n";
  } else {
    answer += "HTTP/1.1 200 OK\n\n";
  }
  answer += resources.getResourceBody(resource);
  return answer;
}
