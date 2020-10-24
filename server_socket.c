#include "server_socket.h"

#define NULL_VALUE_ERROR 1
#define CONNECTION_ERROR -1

int server_socket_t_init(server_socket_t *self) {
  if (self == NULL) return NULL_VALUE_ERROR;
  socket_t newSocket = {-1};
  socket_t newClientSocket = {-1};
  self->socket = newSocket;
  self->clientSocket = newClientSocket;
  socket_t_init(&(self->clientSocket));
  return socket_t_init(&(self->socket));
}

int server_socket_t_destroy(server_socket_t *self) {
  if (self == NULL) return NULL_VALUE_ERROR;
  return (socket_t_destroy(&(self->socket)) ||
          socket_t_destroy(&(self->clientSocket)));
}

bool server_socket_t_bindListen(server_socket_t *self, char *port,
                                bool reusablePort,
                                unsigned int maxAcceptQueueLength) {
  if (self == NULL) return NULL_VALUE_ERROR;
  return socket_t_bindListen(&(self->socket), port, reusablePort,
                             maxAcceptQueueLength);
}

int server_socket_t_accept(server_socket_t *self) {
  if (self == NULL) return NULL_VALUE_ERROR;

  int peer_fd = socket_t_accept(&(self->socket));
  if (peer_fd == -1) return CONNECTION_ERROR;

  (&(self->clientSocket))->fd = peer_fd;
  return 0;
}

ssize_t server_socket_t_recieve(server_socket_t *self, unsigned char *buffer,
                                size_t len) {
  if ((self == NULL) || (buffer == NULL)) return -1;
  return socket_t_recieve(&(self->clientSocket), buffer, len);
}

int server_socket_t_disconnect(server_socket_t *self) {
  if (self == NULL) return NULL_VALUE_ERROR;
  return (socket_t_disconnect(&(self->socket)) ||
          (socket_t_disconnect(&(self->clientSocket))));
}
