#include "server_commandValidator.h"

#define VALID_METHOD_FORMAT "--method="
#define VALID_KEY_FORMAT "--key="

int serverCommandValidator_initialize(serverCommandValidator_t* self, int argc,
                                      char** argv) {
  if ((self == NULL) || (!argc) || (argv == NULL)) return -1;
  self->argc = argc;
  self->argv = argv;
  return 0;
}

static bool serverCommandValidator_t_argumentCountIsValid(
    serverCommandValidator_t* self) {
  return (self->argc == 4);
}

static bool serverCommandValidator_t_MethodAndKeyFormatsAreValid(
    serverCommandValidator_t* self) {
  int i;

  for (i = 0; i < 9; i++) {
    if (self->argv[2][i] != VALID_METHOD_FORMAT[i]) return false;
  }

  for (i = 0; i < 6; i++) {
    if (self->argv[3][i] != VALID_KEY_FORMAT[i]) return false;
  }

  return true;
}

static bool serverCommandValidator_t_encoderIsValid(
    serverCommandValidator_t* self, char encoderName[]) {
  size_t ENCODER_NAME_LENGTH = strlen(encoderName);
  int METHOD_COMMAND_LENGTH = 9 + ENCODER_NAME_LENGTH;

  if (strlen(self->argv[2]) != METHOD_COMMAND_LENGTH) return false;
  char* format = encoderName;

  for (int i = 0; i < ENCODER_NAME_LENGTH; i++) {
    if (self->argv[2][9 + i] != format[i]) return false;
  }
  return true;
}

static bool serverCommandValidator_t_isCesar(serverCommandValidator_t* self) {
  return (serverCommandValidator_t_encoderIsValid(self, "cesar"));
}

static bool serverCommandValidator_t_cesarKeyIsValid(
    serverCommandValidator_t* self) {
  int i = 6;
  while (self->argv[3][i] != '\0') {
    if (!isdigit(self->argv[3][i])) return false;
    i++;
  }
  return true;
}

static bool serverCommandValidator_t_isVigenere(
    serverCommandValidator_t* self) {
  return (serverCommandValidator_t_encoderIsValid(self, "vigenere"));
}

static bool serverCommandValidator_t_isRc4(serverCommandValidator_t* self) {
  return (serverCommandValidator_t_encoderIsValid(self, "rc4"));
}

static bool serverCommandValidator_t_argumentValuesAreValid(
    serverCommandValidator_t* self) {
  if (serverCommandValidator_t_MethodAndKeyFormatsAreValid(self)) {
    if (serverCommandValidator_t_isCesar(self)) {
      return serverCommandValidator_t_cesarKeyIsValid(self);
    }
    return ((serverCommandValidator_t_isVigenere(self)) ||
            (serverCommandValidator_t_isRc4(self)));
  }
  return false;
}

bool serverCommandValidator_t_commandIsValid(serverCommandValidator_t* self) {
  return ((serverCommandValidator_t_argumentCountIsValid(self)) &&
          (serverCommandValidator_t_argumentValuesAreValid(self)));
}
