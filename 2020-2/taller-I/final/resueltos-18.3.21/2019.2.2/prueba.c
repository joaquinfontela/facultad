#include <stdio.h>

int main() {
  int* pi = 1000;
  pi++;
  printf("Pi apunta a la direccion: %l", pi);
  return 0;
}
