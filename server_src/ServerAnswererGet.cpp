#include "ServerAnswererGet.h"

#define ROOT_FILE "/"

ServerAnswererGet::ServerAnswererGet(const HTTPProtocolParser& parser)
    : ServerAnswerer(parser) {}

std::string ServerAnswererGet::getAnswer(
    std::map<std::string, std::string>& resources) {
  std::string resource = httpProtocolParser.getResource();
  if (resources.find(resource) == resources.end()) {
    return "HTTP/1.1 404 NOT FOUND\n\n";
  }
  std::string answer;
  if (resource == ROOT_FILE) {
    answer += "HTTP/1.1 200 OK\nContent-Type: text/html\n\n";
  } else {
    answer += "HTTP/1.1 200 OK\n\n";
  }
  answer += resources.at(resource);
  return std::move(answer);
}