#include "common_socket.h"

typedef struct client_socket {
  socket_t socket;
} client_socket_t;

int client_socket_t_init(client_socket_t *self);

int client_socket_t_destroy(client_socket_t *self);

/*  Pre:          host = IP a la cual conectarse.
 *                port = puerto al cual conectarse.
 *
 *  Pos:          Se guarda el socket con el cual se establecio la
 *                conexion.
 *
 *  RETURN VALUE: false en caso de no poder establecer una conexion, true en
 *                caso de exito.
 *
 */
bool client_socket_t_connect(client_socket_t *self, char *host, char *port);

/*  Pre:          message = el mensaje a ser enviado.
 *                len = el largo del mensaje a ser enviado.
 *
 *  Pos:          Envia todo el mensaje a destino (definido por el valor del
 *                fd del socket).
 *
 *  RETURN VALUE: -1 en caso de error, 0 en caso de exito.
 *
 */
int client_socket_t_send(client_socket_t *self, const char *message,
                         size_t len);

/*  Pre:          buffer = el buffer donde se guarda el mensaje a recibir.
 *                len = tamano del buffer.
 *
 *  Pos:          Guarda en buffer el mensaje recibido con un 0 binario al
 *                final.
 *
 *  RETURN VALUE: -1 en caso de error, o la cantidad de bytes recibidos en caso
 *                de exito.
 */
ssize_t client_socket_t_recieve(client_socket_t *self, unsigned char *buffer,
                                size_t len);

int client_socket_t_disconnect(client_socket_t *self);
