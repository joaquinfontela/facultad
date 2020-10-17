#include "client_commandParser.h"
#include "client_socket.h"
#include "client_stdinReader.h"
#include "common_encoder.h"

#define HOST "127.0.0.1"
#define PORT "8080"

int main(int argc, char* argv[]) {
  clientCommandValidator_t commandValidator;
  clientCommandValidator_initialize(&commandValidator, argc, argv);
  if (!clientCommandValidator_t_commandIsValid(&commandValidator)) return -1;

  clientCommandParser_t commandParser;
  clientCommandParser_t_initialize(&commandParser, argv);

  stdinReader_t stdinReader;
  char message[300];
  stdinReader_t_init(&stdinReader);
  stdinReader_t_read(&stdinReader, message);

  encoder_t encoder;
  encoder_t_init(&encoder, (unsigned char*)commandParser.method,
                 (unsigned char*)commandParser.key);
  encoder_t_encode(&encoder, (unsigned char*)message);

  client_socket_t skt;
  client_socket_t_init(&skt);
  client_socket_t_connect(&skt, HOST, PORT);

  client_socket_t_send(&skt, message, strlen(message));

  client_socket_t_disconnect(&skt);
  client_socket_t_destroy(&skt);

  return 0;
}
