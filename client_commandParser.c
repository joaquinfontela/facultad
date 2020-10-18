#include "client_commandParser.h"

int clientCommandParser_t_initialize(clientCommandParser_t* self, char** argv) {
  if ((self == NULL) || (argv == NULL)) return -1;
  clientCommandParser_t_parseArguments(self, argv);
  return 0;
}

void clientCommandParser_t_parseArguments(clientCommandParser_t* self,
                                          char** argv) {
  self->host = argv[1];
  self->port = argv[2];
  self->method = &(argv[3][9]);
  self->key = &(argv[4][6]);
}
