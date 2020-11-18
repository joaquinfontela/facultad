#include <string>

#include "../common_src/Socket.h"

class ClientSocket : public Socket {
 private:
  void connect(const std::string& host, const std::string& port);

 public:
  ClientSocket(const std::string& host, const std::string& port);
  ClientSocket(const ClientSocket& other) = delete;
};
