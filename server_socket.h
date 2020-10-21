#include "common_socket.h"

typedef struct server_socket {
  socket_t clientSocket;
  socket_t socket;
} server_socket_t;

int server_socket_t_init(server_socket_t *self);

int server_socket_t_destroy(server_socket_t *self);

/*  Pre:          port = puerto al cual conectarse.
 *                reusablePort = variable booleana que define si se ejecutara la
 *                funcion setsockopt sobre el file descriptor.
 *                maxAcceptQueueLength = define el maximo de conexiones en
 *                espera en la cola.
 *
 *  Pos:          Se guarda el socket obtenido con bind y realiza un
 *                listen recibiendo como parametro el valor de
 *                'maxAcceptQueueLength'.
 *
 *  RETURN VALUE: false en caso de fracaso, true en caso de exito.
 *
 */
bool server_socket_t_bindListen(server_socket_t *self, char *port,
                                bool reusablePort,
                                unsigned int maxAcceptQueueLength);

/*  RETURN VALUE: Devuelve el file descriptor que representa la conexion, o -1
 *                en caso de error.
 */
int server_socket_t_accept(server_socket_t *self);

/*  Pre:          message = el mensaje a ser enviado.
 *                len = el largo del mensaje a ser enviado.
 *
 *  Pos:          Envia todo el mensaje a destino (definido por el valor del
 *                fd del socket).
 *
 *  RETURN VALUE: -1 en caso de error, 0 en caso de exito.
 *
 */
int server_socket_t_send(server_socket_t *self, const char *message,
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
ssize_t server_socket_t_recieve(server_socket_t *self, unsigned char *buffer,
                                size_t len);

int server_socket_t_disconnect(server_socket_t *self);
