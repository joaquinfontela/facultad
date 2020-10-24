#include "client_logic.h"

int main(int argc, char* argv[]) {
  client_t client;
  return (client_logic_execute(&client, argc, argv));
}
