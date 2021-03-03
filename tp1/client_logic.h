#include "client_commandParser.h"
#include "client_socket.h"
#include "client_stdinReader.h"
#include "common_encoder.h"

typedef struct client {
  clientCommandParser_t commandParser;
  stdinReader_t stdinReader;
  client_socket_t skt;
  encoder_t encoder;
} client_t;

int client_logic_execute(client_t* self, int argc, char** argv);