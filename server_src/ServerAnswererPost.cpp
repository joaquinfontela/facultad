#include "ServerAnswererPost.h"
#define ROOT_FILE "/"

ServerAnswererPost::ServerAnswererPost(const HTTPProtocolParser& parser)
    : ServerAnswerer(parser) {}

std::string ServerAnswererPost::getAnswer(
    std::map<std::string, std::string>& resources) {
  if (httpProtocolParser.getResource() == ROOT_FILE) {
    return "HTTP/1.1 403 FORBIDDEN\n\n";
  }
  return std::move("HTTP/1.1 200 OK\n\n" + httpProtocolParser.getBody());
}