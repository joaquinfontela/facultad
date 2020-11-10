#include "ClientSocket.h"

#include <string>

ClientSocket::ClientSocket() : Socket() {}

void ClientSocket::connect(const std::string& host, const std::string& port) {
  struct addrinfo* connections = defaultGetAddrInfo(host, port, false);

  struct addrinfo* connectionsCopy = connections;
  while (connectionsCopy != NULL) {
    int fd = socket(connectionsCopy->ai_family, connectionsCopy->ai_socktype,
                    connectionsCopy->ai_protocol);
    if (fd == -1) {
      connectionsCopy = connectionsCopy->ai_next;
      // fprintf(stderr, "%s\n", strerror(errno));
      continue;
    } else if (::connect(fd, connectionsCopy->ai_addr,
                         connectionsCopy->ai_addrlen) == -1) {
      // fprintf(stderr, "%s\n", strerror(errno));
      connectionsCopy = connectionsCopy->ai_next;
      close(fd);
      continue;
    } else {
      this->fd = fd;
    }
    break;
  }
  freeaddrinfo(connections);

  if (this->fd == -1) {
    std::__throw_runtime_error("error connecting");
  }
}
