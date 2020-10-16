#include "common_rc4.h"

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int rc4Encoder_t_initialize(rc4Encoder_t *self, unsigned char key[]) {
  if ((self == NULL) || (key == NULL)) return -1;
  self->key = key;
  return 0;
}

static void rc4Encoder_t_swap(rc4Encoder_t *self, unsigned int i,
                              unsigned int j) {
  unsigned char aux = self->S[i];
  self->S[i] = self->S[j];
  self->S[j] = aux;
}

static void rc4Encoder_t_KSA(rc4Encoder_t *self) {
  unsigned int keyLength = strlen((char *)self->key);
  unsigned int i, j;

  for (i = 0; i < 256; i++) self->S[i] = i;

  for (i = j = 0; i < 256; i++) {
    j = (j + self->key[i % keyLength] + self->S[i]) & 255;
    rc4Encoder_t_swap(self, i, j);
  }
}

static unsigned char rc4Encoder_t_PRGA(rc4Encoder_t *self) {
  unsigned int i = self->i;
  unsigned int j = self->j;

  i = ((i) + 1) & 255;
  j = ((j) + self->S[i]) & 255;

  rc4Encoder_t_swap(self, i, j);

  self->i = i;
  self->j = j;

  return self->S[(self->S[i] + self->S[j]) & 255];
}

void rc4Encoder_t_encode(rc4Encoder_t *self, unsigned char string[]) {
  rc4Encoder_t_KSA(self);

  self->i = 0;
  self->j = 0;
  int n;
  size_t stringLength = strlen((char *)string);

  for (n = 0; n < stringLength; n++) {
    string[n] = string[n] ^ rc4Encoder_t_PRGA(self);
  }
}

void rc4Encoder_t_decode(rc4Encoder_t *self, unsigned char string[]) {
  rc4Encoder_t_encode(self, string);
}

/*
static void rc4Encoder_t_printMessageHexaValues(unsigned char string[]) {
  for (int i = 0; i < strlen(string); i++) printf("%02X |", string[i]);
  puts("\n");
}

int main() {
  unsigned char testString[25] = "En un lugar de la mancha";
  unsigned char testKey[10] = "Cervantes";

  rc4Encoder_t encoder;
  rc4Encoder_t_initialize(&encoder, testKey);
  rc4Encoder_t_encode(&encoder, testString);
  rc4Encoder_t_printMessageHexaValues(testString);

  rc4Encoder_t_decode(&encoder, testString);
  printf("%s\n", testString);

  return 0;
}
*/