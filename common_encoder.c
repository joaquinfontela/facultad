#include "common_encoder.h"

#define NULL_VALUE_ERROR 1
#define METHOD_ERROR 2
#define CESAR "cesar"
#define RC4 "rc4"
#define VIGENERE "vigenere"

int encoder_t_init(encoder_t* self, unsigned char* method, unsigned char* key) {
  if (self == NULL) return NULL_VALUE_ERROR;
  self->key = key;
  self->method = method;

  cesarEncoder_t cesarEncoder;
  cesarEncoder_t_initialize(&cesarEncoder, key);
  self->cesarEncoder = cesarEncoder;

  vigenereEncoder_t vigenereEncoder;
  vigenereEncoder_t_initialize(&vigenereEncoder, key);
  self->vigenereEncoder = vigenereEncoder;

  rc4Encoder_t rc4Encoder;
  rc4Encoder_t_initialize(&rc4Encoder, key);
  self->rc4Encoder = rc4Encoder;

  return 0;
}

int encoder_t_encode(encoder_t* self, unsigned char string[]) {
  if (self == NULL) return NULL_VALUE_ERROR;

  if (!strcmp((char*)self->method, CESAR)) {
    cesarEncoder_t_encode(&(self->cesarEncoder), string);

  } else if (!strcmp((char*)self->method, RC4)) {
    rc4Encoder_t_encode(&(self->rc4Encoder), string);

  } else if (!strcmp((char*)self->method, VIGENERE)) {
    vigenereEncoder_t_encode(&(self->vigenereEncoder), string);

  } else {
    return METHOD_ERROR;
  }

  return 0;
}

int encoder_t_decode(encoder_t* self, unsigned char string[],
                     unsigned int bytesToDecode) {
  if (self == NULL) return NULL_VALUE_ERROR;

  if (!strcmp((char*)self->method, CESAR)) {
    cesarEncoder_t_decode(&(self->cesarEncoder), string, bytesToDecode);

  } else if (!strcmp((char*)self->method, RC4)) {
    rc4Encoder_t_decode(&(self->rc4Encoder), string, bytesToDecode);

  } else if (!strcmp((char*)self->method, VIGENERE)) {
    vigenereEncoder_t_decode(&(self->vigenereEncoder), string, bytesToDecode);

  } else {
    return METHOD_ERROR;
  }

  return 0;
}
