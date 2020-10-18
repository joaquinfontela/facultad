#include "common_socket.h"

typedef struct client_socket {
  socket_t socket;
} client_socket_t;

int client_socket_t_init(client_socket_t *self);

int client_socket_t_destroy(client_socket_t *self);

bool client_socket_t_connect(client_socket_t *self, char *host, char *port);

int client_socket_t_send(client_socket_t *self, const char *message,
                         size_t len);

ssize_t client_socket_t_recieve(client_socket_t *self, unsigned char *buffer,
                                size_t len);

int client_socket_t_disconnect(client_socket_t *self);
