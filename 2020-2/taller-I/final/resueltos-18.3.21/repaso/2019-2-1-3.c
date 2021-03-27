#include <arpa/inet.h>
#include <stdbool.h>
#include <stdio.h>
#include <unistd.h>

bool is_divisible_by_three(uint16_t* number) { return ((*number) % 3 == 0); }

size_t read_next_number(FILE* file, size_t* seek, uint16_t* number) {
  fseek(file, *seek, SEEK_SET);
  size_t res = fread(number, sizeof(uint16_t), 1, file);
  *number = ntohs(*number);
  return res;
}

void write_number(FILE* file, size_t* seek, uint16_t* number) {
  fseek(file, *seek, SEEK_SET);
  fwrite(number, sizeof(uint16_t), 1, file);
  *seek -= sizeof(uint16_t);
}

int main(int argc, char* argv[]) {
  FILE* file = fopen("binary.dat", "r+");

  size_t seek_read = 0;
  size_t seek_write = 0;
  uint16_t number;

  while (read_next_number(file, &seek_read, &number)) {
    seek_write += sizeof(uint16_t);
    seek_read += sizeof(uint16_t);
    if (is_divisible_by_three(&number)) {
      seek_write += sizeof(uint16_t);
    }
  }

  ftruncate(fileno(file), seek_write);
  seek_write -= (sizeof(uint16_t));
  seek_read -= (sizeof(uint16_t));

  while ((int)seek_read >= 0) {
    read_next_number(file, &seek_read, &number);
    seek_read -= sizeof(uint16_t);
    number = htons(number);
    write_number(file, &seek_write, &number);
    if (is_divisible_by_three(&number)) {
      write_number(file, &seek_write, &number);
    }
  }

  fclose(file);
  return 0;
}