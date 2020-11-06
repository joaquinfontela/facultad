#include <netdb.h>
#include <string.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <unistd.h>

#include <string>

class Socket {
 protected:
  int fd;
  struct addrinfo* defaultGetAddrInfo(std::string& host, std::string& port,
                                      bool isServer);

 public:
  Socket();
  Socket(const Socket& other) = delete;
  ~Socket();
};