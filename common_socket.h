#include <errno.h>
#include <netdb.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <unistd.h>

typedef struct {
  int fd;
} socket_t;

int socket_t_init(socket_t *self);

int socket_t_destroy(socket_t *self);

bool socket_t_connect(socket_t *self, char *host, char *port);

bool socket_t_bindListen(socket_t *self, char *port, bool reusablePort,
                         unsigned int maxAcceptQueueLength);

int socket_t_accept(socket_t *self);

int socket_t_send(socket_t *self, const char *message, size_t len);

ssize_t socket_t_recieve(socket_t *self, unsigned char *buffer, size_t len);

int socket_t_disconnect(socket_t *self);
