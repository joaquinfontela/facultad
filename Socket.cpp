#include "Socket.h"

Socket::Socket() : fd(-1) {}

struct addrinfo* Socket::defaultGetAddrInfo(std::string& host,
                                            std::string& port, bool isServer) {
  struct addrinfo* addrinfo;
  struct addrinfo hints;
  memset(&hints, 0, sizeof(struct addrinfo));

  hints.ai_family = AF_INET;        // IPv4 protocol
  hints.ai_socktype = SOCK_STREAM;  // we will always use TCP.
  hints.ai_flags = isServer ? AI_PASSIVE : 0;

  int status = 0;
  if (host.empty()) {
    status = getaddrinfo(NULL, port.c_str(), &hints, &addrinfo);
  } else {
    status = getaddrinfo(host.c_str(), port.c_str(), &hints, &addrinfo);
  }
  if (status != 0) {
    freeaddrinfo(addrinfo);
    // throw -1;
  }
  return addrinfo;
}

Socket::~Socket() {
  shutdown(fd, SHUT_RDWR);
  close(fd);
}