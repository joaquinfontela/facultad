#include "ServerAnswererIncorrectMethod.h"

ServerAnswererIncorrectMethod::ServerAnswererIncorrectMethod(
    const HTTPProtocolParser& parser)
    : ServerAnswerer(parser) {}

std::string ServerAnswererIncorrectMethod::getAnswer(
    ResourcesManager& resources) {
  return "HTTP/1.1 405 METHOD NOT ALLOWED\n\n";
}