#include <stdbool.h>
#include <stdint.h>
#include <stdio.h>
#include <string.h>

typedef struct stdinReader {
  uint32_t chunkSize;
} stdinReader_t;

/*  Pre:          self = un puntero a stdinReader_t no inicializado. *
 *
 *  Pos:          Inicializa el stdinReader.
 *
 *  RETURN VALUE: 1 en caso de error, 0 en caso de exito.
 *
 */
int stdinReader_t_init(stdinReader_t* self);

/*  Pre:          buffer = un puntero a char donde se guardara la informacion
 *                leida.
 *
 *  Pos:          Guarda un chunk de 64 bytes leido desde stdin en buffer con un
 *                0 binario marcando el fin de string.
 *
 *  RETURN VALUE: cantidad de bytes leido desde stdin.
 *
 */
size_t stdinReader_t_readChunk(stdinReader_t* self, char* buffer);
