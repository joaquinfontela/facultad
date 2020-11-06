#include "ServerSocket.h"
#define BUFFER_LEN 1000

ServerSocket::ServerSocket() : clientFd(-1) {}

ServerSocket::~ServerSocket() {
  shutdown(clientFd, SHUT_RDWR);
  close(clientFd);
}

void ServerSocket::_bind(std::string& port, bool reusablePort) {
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

void ServerSocket::_listen(u_int32_t maxAcceptQueueLength) {
  int status = listen(fd, maxAcceptQueueLength);
  if (status < 0) {
    // throw err;
  }
}

void ServerSocket::bindListen(std::string& port, bool reusablePort,
                              u_int32_t maxAcceptQueueLength) {
  _bind(port, reusablePort);
  _listen(maxAcceptQueueLength);
}

void ServerSocket::_accept() { clientFd = accept(fd, NULL, NULL); }

ssize_t ServerSocket::recieve(std::string& buffer, size_t length) {
  size_t bytesRecieved = 0;
  char charBuf[BUFFER_LEN];

  while (bytesRecieved < length) {
    ssize_t bytesRecievedInLastCall =
        recv(clientFd, &charBuf[bytesRecieved], length - bytesRecieved, 0);

    if (bytesRecievedInLastCall == -1) {
      printf("Recieving error.\n");
      fprintf(stderr, "%s\n", strerror(errno));
      // throw err;
    } else if (bytesRecievedInLastCall == 0) {
      break;
    }
    bytesRecieved += bytesRecievedInLastCall;
  }
  uint8_t endOfString = '\0';
  charBuf[bytesRecieved] = endOfString;

  std::string aux(charBuf);
  buffer = aux;
  return bytesRecieved;
}