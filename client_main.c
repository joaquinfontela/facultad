#include <stdbool.h>

#include "client_commandParser.h"
#include "client_socket.h"
#include "client_stdinReader.h"
#include "common_encoder.h"

#define SUCCESS 0
#define COMMAND_PROCESSING_ERROR 1
#define FILE_READING_ERROR 2
#define ENCODING_ERROR 3
#define MESSAGE_SENDING_ERROR 4

bool processCommand(int argc, char* argv[],
                    clientCommandParser_t* commandParser) {
  clientCommandValidator_t commandValidator;
  clientCommandValidator_initialize(&commandValidator, argc, argv);
  if (!clientCommandValidator_t_commandIsValid(&commandValidator)) return false;

  clientCommandParser_t_initialize(commandParser, argv);
  return true;
}

int main(int argc, char* argv[]) {
  clientCommandParser_t commandParser;
  if (!processCommand(argc, argv, &commandParser))
    return COMMAND_PROCESSING_ERROR;

  char message[70];
  size_t bytesRead;
  stdinReader_t stdinReader;
  client_socket_t skt;
  encoder_t encoder;

  stdinReader_t_init(&stdinReader);

  encoder_t_init(&encoder, (unsigned char*)commandParser.method,
                 (unsigned char*)commandParser.key);

  client_socket_t_init(&skt);
  client_socket_t_connect(&skt, commandParser.host, commandParser.port);

  do {
    bytesRead = stdinReader_t_readChunk(&stdinReader, message);
    encoder_t_encode(&encoder, (unsigned char*)message);
    client_socket_t_send(&skt, message, bytesRead);
  } while (bytesRead == 64);

  client_socket_t_disconnect(&skt);
  client_socket_t_destroy(&skt);

  return SUCCESS;
}
