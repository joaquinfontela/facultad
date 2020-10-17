typedef struct vigenereEncoder {
  unsigned char* key;
} vigenereEncoder_t;

int vigenereEncoder_t_initialize(vigenereEncoder_t* self, unsigned char key[]);

void vigenereEncoder_t_encode(vigenereEncoder_t* self, unsigned char string[]);

void vigenereEncoder_t_decode(vigenereEncoder_t* self, unsigned char string[]);