#include "ServerAnswererIncorrectMethod.h"

ServerAnswererIncorrectMethod::ServerAnswererIncorrectMethod(
    const HTTPProtocolParser& parser)
    : ServerAnswerer(parser) {}

std::string ServerAnswererIncorrectMethod::getAnswer(
    std::map<std::string, std::string>& resources) {
  return "HTTP/1.1 405 METHOD NOT ALLOWED\n\n";
}