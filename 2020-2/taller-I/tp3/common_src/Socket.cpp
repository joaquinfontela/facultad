#include "Socket.h"

#include <iostream>
#define TO_READ 64

Socket::Socket() {}

Socket::Socket(int fd) { this->fd = fd; }

void Socket::operator()(int fd) { this->fd = fd; }

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

void Socket::send(const char* message, const size_t length) const {
  size_t bytesSent = 0;

  while (bytesSent < length) {
    ssize_t bytesSentInLastCall =
        ::send(fd, &message[bytesSent], length - bytesSent, MSG_NOSIGNAL);

    if (bytesSentInLastCall == -1) {
      std::string errorDesc(strerror(errno));
      throw std::runtime_error("sending error: " + errorDesc);
    } else if (bytesSentInLastCall == 0) {
      break;
    }
    bytesSent += bytesSentInLastCall;
  }
}

ssize_t Socket::recieve(std::stringbuf& buf) const {
  size_t bytesRecieved = 0;
  ssize_t bytesRecievedInLastCall = 1;

  while (bytesRecievedInLastCall > 0) {
    char buffer[100];
    bytesRecievedInLastCall = recv(fd, buffer, TO_READ, 0);

    if (bytesRecievedInLastCall == -1) {
      std::string errorDesc(strerror(errno));
      throw std::runtime_error("recieving error: " + errorDesc);
    } else if (bytesRecievedInLastCall == 0) {
      break;
    }
    bytesRecieved += bytesRecievedInLastCall;
    buf.sputn(buffer, bytesRecievedInLastCall);
  }
  buf.sputbackc(0);

  return bytesRecieved;
}

void Socket::readShutdown() { shutdown(fd, SHUT_RD); }

void Socket::writeShutdown() { shutdown(fd, SHUT_WR); }
