#include "ServerAnswererPost.h"
#define ROOT_FILE "/"

ServerAnswererPost::ServerAnswererPost(const HTTPProtocolParser& parser)
    : ServerAnswerer(parser) {}

std::string ServerAnswererPost::getAnswer(ResourcesManager& resources) {
  if (httpProtocolParser.getResource() == ROOT_FILE) {
    return "HTTP/1.1 403 FORBIDDEN\n\n";
  }
  updateResources(resources);
  return std::move("HTTP/1.1 200 OK\n\n" + httpProtocolParser.getBody());
}

void ServerAnswererPost::updateResources(ResourcesManager& resources) {
  std::string resource = httpProtocolParser.getResource();
  std::string body = httpProtocolParser.getBody();
  resources.addResource(resource, body);
}