#include "ServerSocket.h"
#define BUFFER_LEN 1000

ServerSocket::ServerSocket() : Socket() {}

void ServerSocket::_bind(const std::string& port, const bool reusablePort) {
  std::string nullStr = "";
  struct addrinfo* connections = defaultGetAddrInfo(nullStr, port, true);

  struct addrinfo* connectionsCopy = connections;

  while (connectionsCopy != NULL) {
    int fd = socket(connectionsCopy->ai_family, connectionsCopy->ai_socktype,
                    connectionsCopy->ai_protocol);

    if (fd == -1) {
      connectionsCopy = connectionsCopy->ai_next;
      // fprintf(stderr, "%s\n", strerror(errno));
      continue;
    } else if (bind(fd, connectionsCopy->ai_addr,
                    connectionsCopy->ai_addrlen) == -1) {
      // fprintf(stderr, "%s\n", strerror(errno));
      connectionsCopy = connectionsCopy->ai_next;
      close(fd);
      continue;
    } else {
      this->fd = fd;
      if (reusablePort) {
        int val = 1;
        setsockopt(fd, SOL_SOCKET, SO_REUSEADDR, &val, sizeof(val));
      }
      break;
    }
  }
}

void ServerSocket::_listen(u_int32_t maxAcceptQueueLength) const {
  int status = listen(fd, maxAcceptQueueLength);
  if (status < 0) {
    // throw err;
  }
}

void ServerSocket::bindListen(const std::string& port, const bool reusablePort,
                              const u_int32_t maxAcceptQueueLength) {
  _bind(port, reusablePort);
  _listen(maxAcceptQueueLength);
}
