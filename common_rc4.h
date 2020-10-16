typedef struct rc4Encoder {
  unsigned char S[256];
  unsigned int i;
  unsigned int j;
  unsigned char *key;
} rc4Encoder_t;

int rc4Encoder_t_initialize(rc4Encoder_t *self, unsigned char key[]);

static void rc4Encoder_t_swap(rc4Encoder_t *self, unsigned int i,
                              unsigned int j);

static void rc4Encoder_t_KSA(rc4Encoder_t *self);

static unsigned char rc4Encoder_t_PRGA(rc4Encoder_t *self);

void rc4Encoder_t_encode(rc4Encoder_t *self, unsigned char string[]);