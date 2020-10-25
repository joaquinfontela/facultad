#include "common_vigenere.h"

#include <stdint.h>
#include <stdio.h>
#include <string.h>

int vigenereEncoder_t_initialize(vigenereEncoder_t* self, unsigned char key[]) {
  if ((self == NULL) || (key == NULL)) return -1;
  self->key = key;
  self->currentKeyPosition = 0;
  return 0;
}

void vigenereEncoder_t_encode(vigenereEncoder_t* self, unsigned char string[]) {
  uint32_t currentStringPosition = 0;
  uint32_t currentKeyPosition = self->currentKeyPosition;
  uint8_t currentChar = string[currentStringPosition];
  while (currentChar != '\0') {
    if (self->key[currentKeyPosition] == '\0') {
      currentKeyPosition = 0;
    }
    string[currentStringPosition] += self->key[currentKeyPosition];
    currentStringPosition++;
    currentKeyPosition++;
    currentChar = string[currentStringPosition];
  }
  self->currentKeyPosition = currentKeyPosition;
}

void vigenereEncoder_t_decode(vigenereEncoder_t* self, unsigned char string[],
                              unsigned int bytesToDecode) {
  uint32_t currentStringPosition = 0;
  uint32_t currentKeyPosition = self->currentKeyPosition;
  uint8_t currentChar = string[currentStringPosition];
  while ((currentChar != '\0') && (currentStringPosition < bytesToDecode)) {
    if (self->key[currentKeyPosition] == '\0') {
      currentKeyPosition = 0;
    }
    string[currentStringPosition] -= self->key[currentKeyPosition];
    currentStringPosition++;
    currentKeyPosition++;
    currentChar = string[currentStringPosition];
  }
  self->currentKeyPosition = currentKeyPosition;
}
