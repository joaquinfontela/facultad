#include "client_stdinReader.h"

#define NULL_VALUE_ERROR 1

int stdinReader_t_init(stdinReader_t* self) {
  if (self == NULL) return NULL_VALUE_ERROR;
  self->chunkSize = 64;
  return 0;
}

size_t stdinReader_t_readChunk(stdinReader_t* self, char* buffer) {
  fgets(buffer, (self->chunkSize) + 1, stdin);
  buffer[strcspn(buffer, "\r\n")] = 0;
  return strlen(buffer);
}