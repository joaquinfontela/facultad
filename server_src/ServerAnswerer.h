#ifndef SERVER_ANSWER_H
#define SERVER_ANSWER_H

#include <iostream>
#include <set>
#include <string>

#include "HTTPProtocolParser.h"
#include "ResourcesManager.h"

class ServerAnswerer {
 protected:
  const HTTPProtocolParser& httpProtocolParser;

 public:
  explicit ServerAnswerer(const HTTPProtocolParser& httpProtocolParser);
  ServerAnswerer(ServerAnswerer&& other) noexcept;

  virtual ~ServerAnswerer() = 0;

  virtual std::string getAnswer(ResourcesManager& resources) = 0;
};

#endif
