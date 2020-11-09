#include "../common_src/Socket.h"

class ServerSocket : public Socket {
 private:
  void bind(const std::string& port, const bool reusablePort);
  void listen(const u_int32_t maxAcceptQueueLength) const;

 public:
  ServerSocket();
  // ServerSocket(const ServerSocket& other) = delete;

  void bindListen(const std::string& port, const bool reusablePort,
                  const u_int32_t maxAcceptQueueLength);
};