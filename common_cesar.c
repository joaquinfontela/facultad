#include "common_cesar.h"

#include <stdio.h>
#include <stdlib.h>

int cesarEncoder_t_initialize(cesarEncoder_t* self, unsigned char offset[]) {
  if (self == NULL) return -1;
  self->offset = strtol((char*)offset, (char**)NULL, 10);
  return 0;
}

void cesarEncoder_t_encode(cesarEncoder_t* self, unsigned char string[]) {
  unsigned int currentPosition = 0;
  unsigned char currentChar = string[currentPosition];
  while (currentChar != '\0') {
    string[currentPosition] = string[currentPosition] + self->offset;
    currentPosition++;
    currentChar = string[currentPosition];
  }
}

void cesarEncoder_t_decode(cesarEncoder_t* self, unsigned char string[]) {
  self->offset = -(self->offset);
  cesarEncoder_t_encode(self, string);
  self->offset = -(self->offset);
}

/*
int main() {
  unsigned char testMessage[] = "Hello world";
  unsigned char testOffset[] = "3";
  cesarEncoder_t encoder;

  cesarEncoder_t_initialize(&encoder, testOffset);
  cesarEncoder_t_encode(&encoder, testMessage);
  printf("%s\n", testMessage);

  cesarEncoder_t_decode(&encoder, testMessage);
  printf("%s\n", testMessage);

  return 0;
}
*/