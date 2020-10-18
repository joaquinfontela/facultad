#include "client_stdinReader.h"

#define NULL_VALUE_ERROR 1

int stdinReader_t_init(stdinReader_t* self) {
  if (self == NULL) return NULL_VALUE_ERROR;
  self->chunkSize = 64;
  return 0;
}

static char* stdinReader_t_readChunk(stdinReader_t* self, char* buffer) {
  return fgets(buffer, (self->chunkSize) + 1, stdin);
}

int stdinReader_t_read(stdinReader_t* self, char* buffer) {
  int bufferPosition = 0;

  while (stdinReader_t_readChunk(self, &buffer[bufferPosition])) {
    bufferPosition += (self->chunkSize);
  }

  buffer[strcspn(buffer, "\r\n")] = 0;

  return 0;
}
