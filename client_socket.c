#include "client_socket.h"

#define NULL_VALUE_ERROR 1

int client_socket_t_init(client_socket_t *self) {
  if (self == NULL) return NULL_VALUE_ERROR;
  socket_t newSocket = {-1};
  self->socket = newSocket;
  return socket_t_init(&(self->socket));
}

int client_socket_t_destroy(client_socket_t *self) {
  if (self == NULL) return NULL_VALUE_ERROR;
  return socket_t_destroy(&(self->socket));
}

bool client_socket_t_connect(client_socket_t *self, char *host, char *port) {
  if ((self == NULL) || (host == NULL) || (port == NULL)) return false;
  return socket_t_connect(&(self->socket), host, port);
}

int client_socket_t_send(client_socket_t *self, const char *message,
                         size_t len) {
  if ((self == NULL) || (message == NULL) || (!len)) return NULL_VALUE_ERROR;
  return socket_t_send(&(self->socket), message, len);
}

int client_socket_t_disconnect(client_socket_t *self) {
  if (self == NULL) return NULL_VALUE_ERROR;
  return socket_t_disconnect(&(self->socket));
}
