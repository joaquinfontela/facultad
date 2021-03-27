#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

#define HEXA_LEN 4

int hexa_char_to_int(const char c) {
  switch (c) {
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
      return atoi(&c);
  }
}

long hexa_to_dec(const char* h) {
  long decimal = 0;
  decimal += hexa_char_to_int(h[0]) * 16 * 16 * 16;
  decimal += hexa_char_to_int(h[1]) * 16 * 16;
  decimal += hexa_char_to_int(h[2]) * 16;
  decimal += hexa_char_to_int(h[3]);
  return decimal;
}

bool read_number(FILE* file, size_t* seek_rd, char* buf) {
  fseek(file, *seek_rd, SEEK_SET);
  char* str = fgets(buf, HEXA_LEN + 1, file);
  if ((long)*seek_rd >= 0) {
    *seek_rd -= 4;
    return true;
  }
  return false;
}

void write_number(FILE* file, size_t* seek_write, long number) {
  fseek(file, *seek_write, SEEK_SET);
  char char_num[5];
  sprintf(char_num, "%ld", number);
  size_t i = strlen(char_num);
  for (i; i < 5; i++) {
    char_num[i] = ' ';
  }
  *seek_write -= 5;
  fputs(char_num, file);
}

int main() {
  FILE* file = fopen("ej7.txt", "r+");
  fseek(file, 0, SEEK_END);
  size_t original_file_size = ftell(file);
  size_t new_file_size = original_file_size / 4 * 5;
  ftruncate(fileno(file), new_file_size);

  size_t seek_read = original_file_size - 4;
  size_t seek_write = new_file_size - 5;
  char buf[5];
  while (read_number(file, &seek_read, buf)) {
    long dec_number = hexa_to_dec(buf);
    write_number(file, &seek_write, dec_number);
  }
  return 0;
}