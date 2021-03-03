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

/*  Pre:          host = IP a la cual conectarse.
 *                port = puerto al cual conectarse.
 *
 *  Pos:          Se guarda el file descriptor con el cual se establecio la
 *                conexion.
 *
 *  RETURN VALUE: false en caso de no poder establecer una conexion, true en
 *                caso de exito.
 *
 */
bool socket_t_connect(socket_t *self, char *host, char *port);

/*  Pre:          port = puerto al cual conectarse.
 *                reusablePort = variable booleana que define si se ejecutara la
 *                funcion setsockopt sobre el file descriptor.
 *                maxAcceptQueueLength = define el maximo de conexiones en
 *                espera en la cola.
 *
 *  Pos:          Se guarda el file descriptor obtenido con bind y realiza un
 *                listen recibiendo como parametro el valor de
 *                'maxAcceptQueueLength'.
 *
 *  RETURN VALUE: false en caso de fracaso, true en caso de exito.
 *
 */
bool socket_t_bindListen(socket_t *self, char *port, bool reusablePort,
                         uint32_t maxAcceptQueueLength);

/*  RETURN VALUE: Devuelve el file descriptor que representa la conexion, o -1
 *                en caso de error.
 */
int socket_t_accept(socket_t *self);

/*  Pre:          message = el mensaje a ser enviado.
 *                len = el largo del mensaje a ser enviado.
 *
 *  Pos:          Envia todo el mensaje a destino (definido por el valor del
 *                fd).
 *
 *  RETURN VALUE: -1 en caso de error, 0 en caso de exito.
 *
 */
int socket_t_send(socket_t *self, const char *message, size_t len);

/*  Pre:          buffer = el buffer donde se guarda el mensaje a recibir.
 *                len = tamano del buffer.
 *
 *  Pos:          Guarda en buffer el mensaje recibido con un 0 binario al
 *                final.
 *
 *  RETURN VALUE: -1 en caso de error, o la cantidad de bytes recibidos en caso
 *                de exito.
 */
ssize_t socket_t_recieve(socket_t *self, uint8_t *buffer, size_t len);

/*  Pos:          Deja el socket desconectado con 'shutdown' y 'close'.
 *
 *  RETURN VALUE: 1 en caso de error, 0 en caso de exito.
 *
 */
int socket_t_disconnect(socket_t *self);
