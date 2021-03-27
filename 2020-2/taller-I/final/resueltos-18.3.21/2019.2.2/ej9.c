#include <arpa/inet.h>
#include <stdint.h>
#include <stdio.h>
#include <unistd.h>

size_t read_next_number(FILE* file, size_t* seek, uint16_t* number) {
  fseek(file, *seek, SEEK_SET);
  size_t res = fread(number, sizeof(uint16_t), 1, file);
  *seek = ftell(file);
  *number = ntohs(*number);
  return res;
}

void write_number(FILE* file, size_t* seek, uint16_t* number) {
  fseek(file, *seek, SEEK_SET);
  *number = htons(*number);
  fwrite(number, sizeof(uint16_t), 1, file);
  *seek = ftell(file);
}

int main(int argc, char* argv[]) {
  FILE* file = fopen("ej9.dat", "r+");
  uint16_t number;

  size_t seek_read = 0;
  size_t seek_write = 0;

  while (read_next_number(file, &seek_read, &number)) {
    if (!(number % 3 == 0)) {
      write_number(file, &seek_write, &number);
    }
  }

  ftruncate(fileno(file), seek_write);
  fclose(file);

  return 0;
}