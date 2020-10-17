#include "client_commandParser.h"
#include "client_socket.h"
#include "common_encoder.h"

#define HOST "127.0.0.1"
#define PORT "8080"

int main(int argc, char* argv[]) {
  clientCommandValidator_t commandValidator;
  clientCommandValidator_initialize(&commandValidator, argc, argv);
  if (!clientCommandValidator_t_commandIsValid(&commandValidator)) return -1;

  clientCommandParser_t commandParser;
  clientCommandParser_t_initialize(&commandParser, argv);

  char message[] = "hello world";
  encoder_t encoder;
  encoder_t_init(&encoder, (unsigned char*)commandParser.method,
                 (unsigned char*)commandParser.key);
  encoder_t_encode(&encoder, (unsigned char*)message);

  client_socket_t skt;
  client_socket_t_init(&skt);
  client_socket_t_connect(&skt, HOST, PORT);

  client_socket_t_send(&skt, message, strlen(message));

  return 0;
}
