#include "ServerAnswer.h"

ServerAnswer::ServerAnswer(const HTTPProtocolParser& http)
    : httpProtocolParser(http), VALID_METHODS({"POST", "GET"}) {}

std::string ServerAnswer::getAnswer() {
  const std::string METHOD = httpProtocolParser.getMethod();
  if (VALID_METHODS.find(METHOD) == VALID_METHODS.end()) {
    return "HTTP 405 METHOD NOT ALLOWED\n\n";
  }
  return "NOPE";
}