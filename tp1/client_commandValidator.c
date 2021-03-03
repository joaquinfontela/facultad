#include "client_commandValidator.h"

#define VALID_METHOD_FORMAT "--method="
#define VALID_KEY_FORMAT "--key="

int clientCommandValidator_initialize(clientCommandValidator_t* self, int argc,
                                      char** argv) {
  if ((self == NULL) || (!argc) || (argv == NULL)) return -1;
  self->argc = argc;
  self->argv = argv;
  return 0;
}

static bool clientCommandValidator_t_argumentCountIsValid(
    clientCommandValidator_t* self) {
  return (self->argc == 5);
}

static bool clientCommandValidator_t_MethodAndKeyFormatsAreValid(
    clientCommandValidator_t* self) {
  int i;

  for (i = 0; i < 9; i++) {
    if (self->argv[3][i] != VALID_METHOD_FORMAT[i]) return false;
  }

  for (i = 0; i < 6; i++) {
    if (self->argv[4][i] != VALID_KEY_FORMAT[i]) return false;
  }

  return true;
}

static bool clientCommandValidator_t_encoderIsValid(
    clientCommandValidator_t* self, char encoderName[]) {
  size_t ENCODER_NAME_LENGTH = strlen(encoderName);
  int METHOD_COMMAND_LENGTH = 9 + ENCODER_NAME_LENGTH;

  if (strlen(self->argv[3]) != METHOD_COMMAND_LENGTH) return false;
  char* format = encoderName;

  for (int i = 0; i < ENCODER_NAME_LENGTH; i++) {
    if (self->argv[3][9 + i] != format[i]) return false;
  }
  return true;
}

static bool clientCommandValidator_t_isCesar(clientCommandValidator_t* self) {
  return (clientCommandValidator_t_encoderIsValid(self, "cesar"));
}

static bool clientCommandValidator_t_cesarKeyIsValid(
    clientCommandValidator_t* self) {
  int i = 6;
  while (self->argv[4][i] != '\0') {
    if (!isdigit(self->argv[4][i])) return false;
    i++;
  }
  return true;
}

static bool clientCommandValidator_t_isVigenere(
    clientCommandValidator_t* self) {
  return (clientCommandValidator_t_encoderIsValid(self, "vigenere"));
}

static bool clientCommandValidator_t_isRc4(clientCommandValidator_t* self) {
  return (clientCommandValidator_t_encoderIsValid(self, "rc4"));
}

static bool clientCommandValidator_t_argumentValuesAreValid(
    clientCommandValidator_t* self) {
  if (clientCommandValidator_t_MethodAndKeyFormatsAreValid(self)) {
    if (clientCommandValidator_t_isCesar(self)) {
      return clientCommandValidator_t_cesarKeyIsValid(self);
    }
    return ((clientCommandValidator_t_isVigenere(self)) ||
            (clientCommandValidator_t_isRc4(self)));
  }
  return false;
}

bool clientCommandValidator_t_commandIsValid(clientCommandValidator_t* self) {
  return ((clientCommandValidator_t_argumentCountIsValid(self)) &&
          (clientCommandValidator_t_argumentValuesAreValid(self)));
}
