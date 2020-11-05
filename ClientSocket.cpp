#include "ClientSocket.h"

ClientSocket::ClientSocket() {}

void ClientSocket::_connect(std::string& host, std::string& port) {
  struct addrinfo* connections = defaultGetAddrInfo(host, port, false);

  struct addrinfo* connectionsCopy = connections;
  while (connectionsCopy != NULL) {
    int fd = socket(connectionsCopy->ai_family, connectionsCopy->ai_socktype,
                    connectionsCopy->ai_protocol);
    if (fd == -1) {
      connectionsCopy = connectionsCopy->ai_next;
      // fprintf(stderr, "%s\n", strerror(errno));
      continue;
    } else if (connect(fd, connectionsCopy->ai_addr,
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
    // throw;
  }
}

void ClientSocket::_send(const std::string& message, size_t length) {
  size_t bytesSent = 0;

  const char* charMsg = message.c_str();
  while (bytesSent < length) {
    ssize_t bytesSentInLastCall =
        send(fd, &charMsg[bytesSent], length - bytesSent, MSG_NOSIGNAL);

    if (bytesSentInLastCall == -1) {
      printf("Sending error.\n");
      // throw err;
    }
    bytesSent += bytesSentInLastCall;
  }
}