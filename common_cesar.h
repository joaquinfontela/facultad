typedef struct cesarEncoder {
  unsigned int offset;
} cesarEncoder_t;

int cesarEncoder_t_initialize(cesarEncoder_t* self, unsigned char offset[]);

void cesarEncoder_t_encode(cesarEncoder_t* self, unsigned char string[]);