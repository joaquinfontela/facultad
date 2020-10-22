#include <ctype.h>
#include <stdio.h>

class CommandValidator {
 private:
  int argc;
  char** argv;

  bool argumentCounterIsValid() const;
  bool threadsCountIsValid() const;

 public:
  CommandValidator(const int argc, char** argv);

  bool commandIsValid() const;
};