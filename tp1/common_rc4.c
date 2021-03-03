#include "common_rc4.h"

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

static void rc4Encoder_t_swap(rc4Encoder_t *self, uint32_t i, uint32_t j) {
  uint8_t aux = self->S[i];
  self->S[i] = self->S[j];
  self->S[j] = aux;
}

static void rc4Encoder_t_KSA(rc4Encoder_t *self) {
  uint32_t keyLength = strlen((char *)self->key);
  uint32_t i, j;

  for (i = 0; i < 256; i++) self->S[i] = i;

  for (i = j = 0; i < 256; i++) {
    j = (j + self->key[i % keyLength] + self->S[i]) & 255;
    rc4Encoder_t_swap(self, i, j);
  }
}

int rc4Encoder_t_initialize(rc4Encoder_t *self, uint8_t key[]) {
  if ((self == NULL) || (key == NULL)) return -1;
  self->key = key;
  rc4Encoder_t_KSA(self);

  self->i = 0;
  self->j = 0;
  return 0;
}

static uint8_t rc4Encoder_t_PRGA(rc4Encoder_t *self) {
  uint32_t i = self->i;
  uint32_t j = self->j;

  i = ((i) + 1) & 255;
  j = ((j) + self->S[i]) & 255;

  rc4Encoder_t_swap(self, i, j);

  self->i = i;
  self->j = j;

  return self->S[(self->S[i] + self->S[j]) & 255];
}

void rc4Encoder_t_encode(rc4Encoder_t *self, uint8_t string[]) {
  int n;
  size_t stringLength = strlen((char *)string);

  for (n = 0; n < stringLength; n++) {
    string[n] = string[n] ^ rc4Encoder_t_PRGA(self);
  }
}

void rc4Encoder_t_decode(rc4Encoder_t *self, uint8_t string[],
                         uint32_t bytesToDecode) {
  int n;
  uint32_t stringLength = bytesToDecode;

  for (n = 0; n < stringLength; n++) {
    string[n] = string[n] ^ rc4Encoder_t_PRGA(self);
  }
}
