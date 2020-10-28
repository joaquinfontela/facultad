#include "CommandValidator.h"

CommandValidator::CommandValidator(const int argc, char** argv) {
  this->argc = argc;
  this->argv = argv;
}

bool CommandValidator::argumentCounterIsValid() const { return (argc > 2); }

bool CommandValidator::threadsCountIsValid() const {
  int i = 0;
  while (argv[1][i] != '\0') {
    if (!isdigit(argv[1][i])) return false;
    i++;
  }
  return true;
}

bool CommandValidator::commandIsValid() const {
  return (argumentCounterIsValid() && threadsCountIsValid());
}
