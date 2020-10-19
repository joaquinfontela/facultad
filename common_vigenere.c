#include "common_vigenere.h"

#include <stdio.h>
#include <string.h>

int vigenereEncoder_t_initialize(vigenereEncoder_t* self, unsigned char key[]) {
  if ((self == NULL) || (key == NULL)) return -1;
  self->key = key;
  self->currentKeyPosition = 0;
  return 0;
}

void vigenereEncoder_t_encode(vigenereEncoder_t* self, unsigned char string[]) {
  unsigned int currentStringPosition = 0;
  unsigned int currentKeyPosition = self->currentKeyPosition;
  unsigned char currentChar = string[currentStringPosition];
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
  unsigned int currentStringPosition = 0;
  unsigned int currentKeyPosition = self->currentKeyPosition;
  unsigned char currentChar = string[currentStringPosition];
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

/*
static void vigenereEncoder_t_printMessageHexaValues(unsigned char string[]) {
  for (int i = 0; i < strlen(string); i++) printf("%02X |", string[i]);
  puts("\n");
}

int main() {
  unsigned char testString[] = "hello world";
  unsigned char testKey[] = "abc";

  vigenereEncoder_t encoder;
  vigenereEncoder_t_initialize(&encoder, testKey);
  vigenereEncoder_t_encode(&encoder, testString);
  vigenereEncoder_t_printMessageHexaValues(testString);

  vigenereEncoder_t_decode(&encoder, testString);
  printf("%s\n", testString);

  return 0;
}
*/
