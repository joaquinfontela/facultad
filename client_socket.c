#include "client_socket.h"

#define NULL_VALUE_ERROR 1

int client_socket_t_init(client_socket_t *self) {
  if (self == NULL) return NULL_VALUE_ERROR;
  socket_t newSocket = {0};
  self->socket = &newSocket;
  return socket_t_init(self->socket);
}

int client_socket_t_destroy(client_socket_t *self) {
  if (self == NULL) return NULL_VALUE_ERROR;
  return socket_t_destroy(self->socket);
}

bool client_socket_t_connect(client_socket_t *self, char *host, char *port) {
  if ((self == NULL) || (host == NULL) || (port == NULL))
    return NULL_VALUE_ERROR;
  return socket_t_connect(self->socket, host, port);
}

int client_socket_t_send(client_socket_t *self, unsigned char *message,
                         size_t len) {
  printf("%d\n", self->socket->fd);
  if ((self == NULL) || (message == NULL) || (!len)) return 0;
  return socket_t_send(self->socket, message, len);
}

int client_socket_t_recieve(client_socket_t *self, unsigned char *buffer,
                            size_t len) {
  if ((self == NULL) || (buffer == NULL) || (!len)) return 0;
  return socket_t_recieve(self->socket, buffer, len);
}

int client_socket_t_disconnect(client_socket_t *self) {
  if (self == NULL) return NULL_VALUE_ERROR;
  return socket_t_disconnect(self->socket);
}

/*
int main() {
  printf("%s\n", "Holi");
  return 0;
}
*/