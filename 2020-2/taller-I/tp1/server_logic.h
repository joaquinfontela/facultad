#include "common_encoder.h"
#include "server_commandParser.h"
#include "server_socket.h"

typedef struct server {
  serverCommandParser_t commandParser;
  server_socket_t skt;
  encoder_t decoder;
} server_t;

int server_logic_execute(server_t* self, int argc, char* argv[]);
