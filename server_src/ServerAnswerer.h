#ifndef SERVER_ANSWER_H
#define SERVER_ANSWER_H

#include <iostream>
#include <set>
#include <string>

#include "HTTPProtocolParser.h"

class ServerAnswerer {
 protected:
  const HTTPProtocolParser& httpProtocolParser;

 public:
  ServerAnswerer(const HTTPProtocolParser& httpProtocolParser);

  ServerAnswerer(ServerAnswerer&& other) noexcept;

  virtual std::string getAnswer(
      std::map<std::string, std::string>& resources) = 0;
};

#endif