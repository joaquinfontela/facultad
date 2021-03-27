#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int getDecimalValue(char val) {
  switch (val) {
    case 'A':
      return 10;
    case 'B':
      return 11;
    case 'C':
      return 12;
    case 'D':
      return 13;
    case 'E':
      return 14;
    case 'F':
      return 15;
    default:
      return atoi(&val);
  }
}

long int pwr(int a, int b) {
  long int value = 1;
  while (b > 0) {
    value *= a;
    b--;
  }
  return value;
}

void ValorHex(char* hex, int* ent) {
  int hex_pos = strlen(hex) - 1;
  int power = 0;
  *ent = 0;
  while (hex_pos >= 0) {
    char val = hex[hex_pos];
    int num_val = getDecimalValue(val);
    *ent += (num_val * pwr(16, power));
    hex_pos--;
    power++;
  }
}

int main(int argc, char argv) {
  int value;
  char* string = "FFF";
  ValorHex(string, &value);
  printf("%i", value);
  return 0;
}