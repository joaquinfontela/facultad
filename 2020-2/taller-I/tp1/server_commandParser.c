#include "server_commandParser.h"

int serverCommandParser_t_initialize(serverCommandParser_t* self, char** argv) {
  if ((self == NULL) || (argv == NULL)) return -1;
  serverCommandParser_t_parseArguments(self, argv);
  return 0;
}

void serverCommandParser_t_parseArguments(serverCommandParser_t* self,
                                          char** argv) {
  self->port = argv[1];
  self->method = &(argv[2][9]);
  self->key = &(argv[3][6]);
}
