#include "common_encoder.h"

#define NULL_VALUE_ERROR 1
#define METHOD_ERROR 2

int encoder_t_init(encoder_t* self, unsigned char* method, unsigned char* key) {
  if (self == NULL) return NULL_VALUE_ERROR;
  self->key = key;
  self->method = method;
  return 0;
}

int encoder_t_encode(encoder_t* self, unsigned char string[]) {
  if (self == NULL) return NULL_VALUE_ERROR;

  const char cesar[] = "cesar";
  const char rc4[] = "rc4";
  const char vigenere[] = "vigenere";

  if (!strcmp((char*)self->method, cesar)) {
    cesarEncoder_t e = {0};
    cesarEncoder_t* encoder = &e;
    cesarEncoder_t_initialize(encoder, self->key);
    cesarEncoder_t_encode(encoder, string);
  } else if (!strcmp((char*)self->method, rc4)) {
    rc4Encoder_t e = {{0}, 0, 0, 0};
    rc4Encoder_t* encoder = &e;
    rc4Encoder_t_initialize(encoder, self->key);
    rc4Encoder_t_encode(encoder, string);
  } else if (!strcmp((char*)self->method, vigenere)) {
    vigenereEncoder_t e = {0};
    vigenereEncoder_t* encoder = &e;
    vigenereEncoder_t_initialize(encoder, self->key);
    vigenereEncoder_t_encode(encoder, string);
  } else {
    return METHOD_ERROR;
  }
  return 0;
}

int encoder_t_decode(encoder_t* self, unsigned char string[]) {
  if (self == NULL) return NULL_VALUE_ERROR;

  const char cesar[] = "cesar";
  const char rc4[] = "rc4";
  const char vigenere[] = "vigenere";

  if (!strcmp((char*)self->method, cesar)) {
    cesarEncoder_t e = {0};
    cesarEncoder_t* encoder = &e;
    cesarEncoder_t_initialize(encoder, self->key);
    cesarEncoder_t_decode(encoder, string);
  } else if (!strcmp((char*)self->method, rc4)) {
    rc4Encoder_t e = {{0}, 0, 0, 0};
    rc4Encoder_t* encoder = &e;
    rc4Encoder_t_initialize(encoder, self->key);
    rc4Encoder_t_decode(encoder, string);
  } else if (!strcmp((char*)self->method, vigenere)) {
    vigenereEncoder_t e = {0};
    vigenereEncoder_t* encoder = &e;
    vigenereEncoder_t_initialize(encoder, self->key);
    vigenereEncoder_t_decode(encoder, string);
  } else {
    return METHOD_ERROR;
  }
  return 0;
}
