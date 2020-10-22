#include "CommandValidator.h"

CommandValidator::CommandValidator(const int argc, char** argv) {
  this->argc = argc;
  this->argv = argv;
}

bool CommandValidator::argumentCounterIsValid() const {
  return (this->argc > 2);
}

bool CommandValidator::threadsCountIsValid() const {
  int i = 0;
  while (this->argv[1][i] != '\0') {
    if (!isdigit(this->argv[1][i])) return false;
    i++;
  }
  return true;
}

bool CommandValidator::commandIsValid() const {
  return (this->argumentCounterIsValid() && this->threadsCountIsValid());
}
