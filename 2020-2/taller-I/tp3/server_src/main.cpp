#include <iostream>

#include "Server.h"

int main(int argc, char* argv[]) {
  ServerCommandParser commandParser;
  if (!commandParser.commandIsValid(argc, argv)) return 1;

  try {
    Server s(commandParser);
    s.run();
  } catch (const std::exception& e) {
    std::cout << e.what() << std::endl;
  } catch (...) {
    std::cout << "error desconocido" << std::endl;
  }

  return 0;
}
