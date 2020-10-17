#define _XOPEN_SOURCE 600
#include "common_socket.h"

#define SEND_ERROR -1
#define SUCCESS 0
#define NULL_VALUE_ERROR 1
#define ADDR_ERROR NULL

int socket_t_init(socket_t *self) {
  if (self == NULL) return NULL_VALUE_ERROR;
  self->fd = -1;
  return SUCCESS;
}

int socket_t_destroy(socket_t *self) { return socket_t_init(self); }

static struct addrinfo *socket_t_defaultGetAddrInfo(char *host, char *port,
                                                    bool isServer) {
  struct addrinfo *addrinfo;
  struct addrinfo hints;
  memset(&hints, 0, sizeof(struct addrinfo));

  hints.ai_family = AF_INET;        // IPv4 protocol
  hints.ai_socktype = SOCK_STREAM;  // we will always use TCP.
  hints.ai_flags = isServer ? AI_PASSIVE : 0;

  int status = 0;
  status = getaddrinfo(host, port, &hints, &addrinfo);
  if (status != 0) {
    // fprintf(stderr, "%s\n", strerror(errno));
    freeaddrinfo(addrinfo);
    return ADDR_ERROR;
  }
  return addrinfo;
}

static bool socket_t_connectionFailure(socket_t *self) {
  socket_t_disconnect(self);
  socket_t_destroy(self);
  return false;
}

bool socket_t_connect(socket_t *self, char *host, char *port) {
  struct addrinfo *connections = socket_t_defaultGetAddrInfo(NULL, port, false);
  if (connections == ADDR_ERROR) {
    return socket_t_connectionFailure(self);
  }

  int fd;
  struct addrinfo *connectionsCopy = connections;
  while (connectionsCopy != NULL) {
    fd = socket(connectionsCopy->ai_family, connectionsCopy->ai_socktype,
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
      self->fd = fd;
    }
    break;
  }

  freeaddrinfo(connections);

  if (self->fd == -1) {
    return false;
  }

  return true;
}

static bool socket_t_bind(socket_t *self, char *port, bool reusablePort) {
  struct addrinfo *connections = socket_t_defaultGetAddrInfo(NULL, port, false);
  if (connections == ADDR_ERROR) {
    return socket_t_connectionFailure(self);
  }

  int fd;
  struct addrinfo *connectionsCopy = connections;
  while (connectionsCopy != NULL) {
    fd = socket(connectionsCopy->ai_family, connectionsCopy->ai_socktype,
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
      self->fd = fd;
      if (reusablePort) {
        int val = 1;
        setsockopt(fd, SOL_SOCKET, SO_REUSEADDR, &val, sizeof(val));
      }
      break;
    }
  }

  freeaddrinfo(connections);

  if (self->fd == -1) {
    return false;
  }

  return true;
}

static bool socket_t_listen(socket_t *self, unsigned int maxAcceptQueueLength) {
  int status = listen(self->fd, maxAcceptQueueLength);
  if (status < 0) {
    socket_t_connectionFailure(self);
    return false;
  }
  return true;
}

bool socket_t_bindListen(socket_t *self, char *port, bool reusablePort,
                         unsigned int maxAcceptQueueLength) {
  return ((socket_t_bind(self, port, reusablePort)) &&
          (socket_t_listen(self, maxAcceptQueueLength)));
}

int socket_t_accept(socket_t *self) { return accept(self->fd, NULL, NULL); }

int socket_t_send(socket_t *self, const char *message, size_t len) {
  size_t remainingBytes = len;
  size_t bytesSent = 0;

  while (bytesSent < remainingBytes) {
    puts("Sending...");
    ssize_t bytesSentInLastCall =
        send(self->fd, &message[bytesSent], remainingBytes, MSG_NOSIGNAL);

    if (bytesSentInLastCall == SEND_ERROR) {
      printf("Sending error.\n");
      fprintf(stderr, "%s\n", strerror(errno));
      return SEND_ERROR;
    } else if (bytesSentInLastCall == 0) {
      break;
    }

    remainingBytes -= bytesSentInLastCall;
    bytesSent += bytesSentInLastCall;
  }

  return 0;
}

int socket_t_recieve(socket_t *self, unsigned char *buffer, size_t len) {
  size_t remainingBytes = len;
  size_t bytesRecieved = 0;

  while (bytesRecieved < remainingBytes) {
    puts("Recieving...");
    ssize_t bytesRecievedInLastCall =
        recv(self->fd, &buffer[bytesRecieved], remainingBytes, 0);

    if (bytesRecievedInLastCall == SEND_ERROR) {
      printf("Recieving error.\n");
      fprintf(stderr, "%s\n", strerror(errno));
      return SEND_ERROR;
    } else if (bytesRecievedInLastCall == 0) {
      break;
    }

    remainingBytes -= bytesRecievedInLastCall;
    bytesRecieved += bytesRecievedInLastCall;
  }

  return 0;
}

int socket_t_disconnect(socket_t *self) {
  if (self == NULL) return NULL_VALUE_ERROR;
  shutdown(self->fd, SHUT_RDWR);
  close(self->fd);
  return 0;
}
