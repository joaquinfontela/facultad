#include "../common_src/Socket.h"

class ServerSocket : public Socket {
 private:
  int clientFd;
  void _bind(std::string& port, bool reusablePort);
  void _listen(u_int32_t maxAcceptQueueLength);

 public:
  ServerSocket();
  ServerSocket(const ServerSocket& other) = delete;
  ~ServerSocket();

  void bindListen(std::string& port, bool reusablePort,
                  u_int32_t maxAcceptQueueLength);
  void _accept();
  ssize_t recieve(std::string& buffer, size_t length);
};