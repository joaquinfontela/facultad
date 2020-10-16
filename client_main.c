#include "client_commandParser.h"
#include "client_socket.h"

#define HOST "127.0.0.1"
#define PORT "8080"

/*
int main(int argc, char* argv[]) {
  clientCommandValidator_t commandValidator;
  clientCommandValidator_initialize(&commandValidator, argc, argv);
  if (!clientCommandValidator_t_commandIsValid(&commandValidator)) return -1;

  clientCommandParser_t commandParser;
  clientCommandParser_t_initialize(&commandParser, argv);
  return 0;
}*/

int main() {
  client_socket_t skt;
  if (client_socket_t_init(&skt)) puts("Error en el init");
  if (!client_socket_t_connect(&skt, HOST, PORT)) puts("Error en el connect");

  unsigned char message[10] = "Hola mundo";
  printf("%d\n", skt.socket->fd);
  client_socket_t_send(&skt, message, 10);

  return 0;
}
