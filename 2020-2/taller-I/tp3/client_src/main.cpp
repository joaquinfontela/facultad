#include "Client.h"

int main(int argc, char* argv[]) {
  ClientCommandParser commandParser;
  if (!commandParser.commandIsValid(argc, argv)) return 0;

  try {
    Client c(commandParser);
    c.run();
  } catch (const std::exception& e) {
    std::cout << e.what() << std::endl;
  } catch (...) {
    std::cout << "error desconocido" << std::endl;
  }

  return 0;
}
