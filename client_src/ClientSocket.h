#include "../common_src/Socket.h"

class ClientSocket : public Socket {
 public:
  ClientSocket();
  ClientSocket(const ClientSocket& other) = delete;

  void connect(const std::string& host, const std::string& port);
};