#include <iostream>

#include "Server.h"

int main(int argc, char* argv[]) {
  ServerCommandParser commandParser;
  if (!commandParser.commandIsValid(argc, argv)) return 1;

  Server s(commandParser);
  s.run();

  return 0;
}
