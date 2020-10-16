#include <stdio.h>

#include "client_commandValidator.h"

typedef struct clientCommandParser {
  char* host;
  char* port;
  char* method;
  char* key;
} clientCommandParser_t;

int clientCommandParser_t_initialize(clientCommandParser_t* self, char** argv);

void clientCommandParser_t_parseArguments(clientCommandParser_t* self,
                                          char** argv);