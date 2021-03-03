#include <string>

#include "../common_src/Socket.h"

class ServerSocket : public Socket {
 private:
  void bind(const std::string& port, const bool reusablePort);
  void listen(const u_int32_t maxAcceptQueueLength) const;
  void bindListen(const std::string& port, const bool reusablePort,
                  const u_int32_t maxAcceptQueueLength);

 public:
  ServerSocket();
  ServerSocket(const std::string& port, const bool reusablePort,
               const u_int32_t maxAcceptQueueLength);
  // ServerSocket(const ServerSocket& other) = delete;

  void close();
};
