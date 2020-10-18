#include "common_encoder.h"
#include "server_commandParser.h"
#include "server_socket.h"

#define SUCCESS 0
#define MESSAGE_RECEVING_ERROR -1
#define COMMAND_PROCESSING_ERROR 1
#define DECODING_ERROR 2

#define BUFFER_SIZE 1000

bool processCommand(int argc, char* argv[],
                    serverCommandParser_t* commandParser) {
  serverCommandValidator_t commandValidator;
  serverCommandValidator_initialize(&commandValidator, argc, argv);
  if (!serverCommandValidator_t_commandIsValid(&commandValidator)) return false;

  serverCommandParser_t_initialize(commandParser, argv);
  return true;
}

ssize_t recieveMessage(serverCommandParser_t* commandParser,
                       unsigned char* buf) {
  server_socket_t skt;
  server_socket_t_init(&skt);

  if (!server_socket_t_bindListen(&skt, commandParser->port, true, 10))
    return MESSAGE_RECEVING_ERROR;
  if (server_socket_t_accept(&skt) == -1) return MESSAGE_RECEVING_ERROR;
  ssize_t bytesRecieved = server_socket_t_recieve(&skt, buf, BUFFER_SIZE);
  if (bytesRecieved == -1) return MESSAGE_RECEVING_ERROR;

  server_socket_t_disconnect(&skt);
  server_socket_t_destroy(&skt);

  return bytesRecieved;
}

bool decode(serverCommandParser_t* commandParser, unsigned char* buf,
            size_t bytesRecieved) {
  encoder_t encoder;
  if (encoder_t_init(&encoder, (unsigned char*)commandParser->method,
                     (unsigned char*)commandParser->key) == 1)
    return false;
  if (encoder_t_decode(&encoder, buf, bytesRecieved) != 0) return false;
  return true;
}

int main(int argc, char* argv[]) {
  serverCommandParser_t commandParser;
  if (!processCommand(argc, argv, &commandParser))
    return COMMAND_PROCESSING_ERROR;

  unsigned char buf[BUFFER_SIZE];
  ssize_t bytesRecieved = recieveMessage(&commandParser, buf);

  if (!decode(&commandParser, buf, bytesRecieved)) return DECODING_ERROR;

  printf("%s\n", buf);

  return 0;
}
