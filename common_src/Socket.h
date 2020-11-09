#include <netdb.h>
#include <string.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <unistd.h>

#include <string>

class Socket {
 protected:
  int fd;
  struct addrinfo* defaultGetAddrInfo(const std::string& host,
                                      const std::string& port,
                                      const bool isServer) const;

 public:
  Socket();
  explicit Socket(int fd);
  void operator()(int fd);
  Socket& operator=(Socket&& other);
  Socket(const Socket& other) = delete;
  ~Socket();
  int accept();
  void send(const std::string& message, const size_t length) const;
  ssize_t recieve(std::string& buffer, const size_t length) const;

  void readShutdown();
  void writeShutdown();
};