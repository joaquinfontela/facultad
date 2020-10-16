#include <ctype.h>
#include <stdbool.h>
#include <stdio.h>
#include <string.h>

typedef struct serverCommandValidator {
  int argc;
  char** argv;
} serverCommandValidator_t;

int serverCommandValidator_initialize(serverCommandValidator_t* self, int argc,
                                      char** argv);

bool serverCommandValidator_t_commandIsValid(serverCommandValidator_t* self);