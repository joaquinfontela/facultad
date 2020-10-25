#include "common_cesar.h"

#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>

int cesarEncoder_t_initialize(cesarEncoder_t* self, unsigned char offset[]) {
  if (self == NULL) return -1;
  self->offset = strtol((char*)offset, (char**)NULL, 10);
  return 0;
}

void cesarEncoder_t_encode(cesarEncoder_t* self, unsigned char string[]) {
  uint32_t currentPosition = 0;
  uint8_t currentChar = string[currentPosition];
  while (currentChar != '\0') {
    string[currentPosition] = string[currentPosition] + self->offset;
    currentPosition++;
    currentChar = string[currentPosition];
  }
}

void cesarEncoder_t_decode(cesarEncoder_t* self, unsigned char string[],
                           unsigned int bytesToDecode) {
  uint32_t currentPosition = 0;
  uint8_t currentChar = string[currentPosition];
  while ((currentChar != '\0') && (currentPosition < bytesToDecode)) {
    string[currentPosition] = string[currentPosition] - self->offset;
    currentPosition++;
    currentChar = string[currentPosition];
  }
}
