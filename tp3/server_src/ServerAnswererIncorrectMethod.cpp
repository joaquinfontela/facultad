#include "ServerAnswererIncorrectMethod.h"

ServerAnswererIncorrectMethod::ServerAnswererIncorrectMethod(
    const HTTPProtocolParser& parser)
    : ServerAnswerer(parser) {}

ServerAnswererIncorrectMethod::~ServerAnswererIncorrectMethod() {}

std::string ServerAnswererIncorrectMethod::getAnswer(
    ResourcesManager& resources) const {
  std::string answer = "HTTP/1.1 405 METHOD NOT ALLOWED\n\n";
  answer += (httpProtocolParser.getMethod() + " es un comando desconocido");
  return answer;
}
