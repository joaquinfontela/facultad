#include "Socket.h"

#include <iostream>
#define BUFFER_LEN 1000

Socket::Socket() : fd(-1) {}

Socket::Socket(int fd) { this->fd = fd; }

struct addrinfo* Socket::defaultGetAddrInfo(const std::string& host,
                                            const std::string& port,
                                            const bool isServer) const {
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

void Socket::_accept() { fd = accept(fd, NULL, NULL); }

void Socket::_send(const std::string& message, const size_t length) const {
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
    std::cout << bytesSent << std::endl;
  }
}

ssize_t Socket::recieve(std::string& buffer, const size_t length) const {
  size_t bytesRecieved = 0;
  char charBuf[BUFFER_LEN];

  while (bytesRecieved < length) {
    ssize_t bytesRecievedInLastCall =
        recv(fd, &charBuf[bytesRecieved], length - bytesRecieved, 0);

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