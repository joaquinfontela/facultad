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

ssize_t readMessage(char* message) {
  stdinReader_t stdinReader;
  if (stdinReader_t_init(&stdinReader)) return -1;
  stdinReader_t_read(&stdinReader, message);
  return strlen(message);
}

bool encode(clientCommandParser_t* commandParser, char* message) {
  encoder_t encoder;
  if (encoder_t_init(&encoder, (unsigned char*)commandParser->method,
                     (unsigned char*)commandParser->key) == 1)
    return false;
  if (encoder_t_encode(&encoder, (unsigned char*)message) != 0) return false;
  return true;
}

bool sendMessage(client_socket_t* skt, clientCommandParser_t* commandParser,
                 char* message, size_t messageLen) {
  client_socket_t_init(skt);
  if (!client_socket_t_connect(skt, commandParser->host, commandParser->port))
    return false;

  if (client_socket_t_send(skt, message, messageLen) != 0) return false;

  client_socket_t_disconnect(skt);
  client_socket_t_destroy(skt);
  return true;
}

int main(int argc, char* argv[]) {
  clientCommandParser_t commandParser;
  if (!processCommand(argc, argv, &commandParser))
    return COMMAND_PROCESSING_ERROR;

  char message[1000];
  ssize_t messageLen = readMessage(message);
  if (messageLen == -1) return FILE_READING_ERROR;

  if (!encode(&commandParser, message)) return ENCODING_ERROR;

  client_socket_t skt;
  if (!sendMessage(&skt, &commandParser, message, messageLen))
    return MESSAGE_SENDING_ERROR;

  return SUCCESS;
}
