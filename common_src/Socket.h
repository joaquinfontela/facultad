#include <netdb.h>
#include <string.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <unistd.h>

#include <sstream>
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
  Socket(Socket&& other);
  Socket(const Socket& other) = delete;
  ~Socket();

  int accept() const;
  void send(const char* message, const size_t length) const;
  ssize_t recieve(char* buf, const size_t length) const;

  void readShutdown();
  void writeShutdown();
};
