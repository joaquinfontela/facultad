#include "server_logic.h"

int main(int argc, char* argv[]) {
  server_t server;
  return (server_logic_execute(&server, argc, argv));
}
