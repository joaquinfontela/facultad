#include <iostream>
#include <string>

#include "ClientCommandParser.h"
#include "ClientSocket.h"
#include "HTTPProtocolReader.h"

class Client {
 private:
  const std::string HOST;
  const std::string PORT;

 public:
  explicit Client(const ClientCommandParser& commandParser);
  void run() const;
};
