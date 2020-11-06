#include "../common_src/Socket.h"

class ClientSocket : public Socket {
 public:
  ClientSocket();
  ClientSocket(const ClientSocket& other) = delete;

  void _connect(std::string& host, std::string& port);
  void _send(const std::string& message, size_t length);
};