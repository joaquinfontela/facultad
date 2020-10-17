#include "common_socket.h"

typedef struct server_socket {
  socket_t clientSocket;
  socket_t socket;
} server_socket_t;

int server_socket_t_init(server_socket_t *self);

int server_socket_t_destroy(server_socket_t *self);

bool server_socket_t_bindListen(server_socket_t *self, char *port,
                                bool reusablePort,
                                unsigned int maxAcceptQueueLength);

int server_socket_t_accept(server_socket_t *self);

int server_socket_t_send(server_socket_t *self, const char *message,
                         size_t len);

int server_socket_t_recieve(server_socket_t *self, unsigned char *buffer,
                            size_t len);

int server_socket_t_disconnect(server_socket_t *self);