#include <ctype.h>
#include <stdbool.h>
#include <stdio.h>
#include <string.h>

typedef struct clientCommandValidator {
  int argc;
  char** argv;
} clientCommandValidator_t;

int clientCommandValidator_initialize(clientCommandValidator_t* self, int argc,
                                      char** argv);

bool clientCommandValidator_t_commandIsValid(clientCommandValidator_t* self);