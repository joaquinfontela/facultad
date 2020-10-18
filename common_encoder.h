#include <stdio.h>
#include <string.h>

#include "common_cesar.h"
#include "common_rc4.h"
#include "common_vigenere.h"

typedef struct encoder {
  unsigned char* method;
  unsigned char* key;
} encoder_t;

int encoder_t_init(encoder_t* self, unsigned char* method, unsigned char* key);

int encoder_t_encode(encoder_t* self, unsigned char string[]);

int encoder_t_decode(encoder_t* self, unsigned char string[],
                     unsigned int bytesToDecode);
