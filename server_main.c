#include "server_commandParser.h"
#include "server_socket.h"

#define PORT "8080"

/*
int main(int argc, char* argv[]) {
  serverCommandValidator_t commandValidator;
  serverCommandValidator_initialize(&commandValidator, argc, argv);
  if (!serverCommandValidator_t_commandIsValid(&commandValidator)) return -1;

  serverCommandParser_t commandParser;
  serverCommandParser_t_initialize(&commandParser, argv);
  return 0;
}
*/

int main() {
  server_socket_t skt;
  server_socket_t_init(&skt);
  server_socket_t_bindListen(&skt, PORT, true, 10);
  server_socket_t_accept(&skt);

  unsigned char buf;
  printf("%d\n", (&skt)->clientSocket->fd);
  server_socket_t_recieve(&skt, &buf, 10);

  // printf("%s\n", &buf);
  return 0;
}