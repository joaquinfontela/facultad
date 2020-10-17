typedef struct rc4Encoder {
  unsigned char S[256];
  unsigned int i;
  unsigned int j;
  unsigned char *key;
} rc4Encoder_t;

int rc4Encoder_t_initialize(rc4Encoder_t *self, unsigned char key[]);

void rc4Encoder_t_encode(rc4Encoder_t *self, unsigned char string[]);

void rc4Encoder_t_decode(rc4Encoder_t *self, unsigned char string[]);
