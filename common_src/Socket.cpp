#include "Socket.h"

#include <iostream>
#define BUFFER_LEN 1000

Socket::Socket() : fd(-1) {}

Socket::Socket(int fd) { this->fd = fd; }

void Socket::operator()(int fd) { this->fd = fd; }

Socket& Socket::operator=(Socket&& other) {
  this->fd = other.fd;
  other.fd = -1;
  return *this;
}

Socket::Socket(Socket&& other) {
  this->fd = other.fd;
  other.fd = -1;
}

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
    throw std::runtime_error("error getting adress");
  }
  return addrinfo;
}

Socket::~Socket() {
  if (fd == -1) return;
  shutdown(fd, SHUT_RDWR);
  close(fd);
}

int Socket::accept() const {
  int peerfd = ::accept(fd, nullptr, nullptr);
  if (peerfd == -1) throw std::invalid_argument("socket closed.");
  return peerfd;
}

void Socket::send(const std::string& message, const size_t length) const {
  size_t bytesSent = 0;

  const char* charMsg = message.c_str();
  while (bytesSent < length) {
    ssize_t bytesSentInLastCall =
        ::send(fd, &charMsg[bytesSent], length - bytesSent, MSG_NOSIGNAL);

    if (bytesSentInLastCall == -1) {
      std::string errorDesc(strerror(errno));
      throw std::runtime_error("sending error: " + errorDesc);
    } else if (bytesSentInLastCall == 0) {
      break;
    }
    bytesSent += bytesSentInLastCall;
  }
}

ssize_t Socket::recieve(std::string& buffer, const size_t length) const {
  size_t bytesRecieved = 0;
  char charBuf[BUFFER_LEN];

  while (bytesRecieved < length) {
    ssize_t bytesRecievedInLastCall =
        recv(fd, &charBuf[bytesRecieved], length - bytesRecieved, 0);

    if (bytesRecievedInLastCall == -1) {
      std::string errorDesc(strerror(errno));
      throw std::runtime_error("recieving error: " + errorDesc);
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

void Socket::readShutdown() { shutdown(fd, SHUT_RD); }

void Socket::writeShutdown() { shutdown(fd, SHUT_WR); }
