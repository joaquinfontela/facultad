#include <stdbool.h>
#include <stdio.h>
#include <string.h>

typedef struct stdinReader {
  int chunkSize;
} stdinReader_t;

int stdinReader_t_init(stdinReader_t* self);

size_t stdinReader_t_readChunk(stdinReader_t* self, char* buffer);
