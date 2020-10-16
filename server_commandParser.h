#include <stdio.h>

#include "server_commandValidator.h"

typedef struct serverCommandParser {
  char* port;
  char* method;
  char* key;
} serverCommandParser_t;

int serverCommandParser_t_initialize(serverCommandParser_t* self, char** argv);

void serverCommandParser_t_parseArguments(serverCommandParser_t* self,
                                          char** argv);