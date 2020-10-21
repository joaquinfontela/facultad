#include <stdio.h>

#include "server_commandValidator.h"

typedef struct serverCommandParser {
  char* port;
  char* method;
  char* key;
} serverCommandParser_t;

/*  Pre:          self = un puntero a serverCommandParser_t no inicializado.
 *                argv = el vector de argumentos del comando en la terminal.
 *
 *
 *  Pos:          Inicializa el parser.
 *
 *  RETURN VALUE: -1 en caso de error, 0 en caso de exito.
 *
 */
int serverCommandParser_t_initialize(serverCommandParser_t* self, char** argv);

/*  Pre:          argv = el vector de argumentos del comando en la terminal.
 *
 *
 *  Pos:          Se guarda los valores ingresados por linea de comando
 *                de port, method y key en el struct.
 *
 *  RETURN VALUE: -1 en caso de error, 0 en caso de exito.
 *
 */
void serverCommandParser_t_parseArguments(serverCommandParser_t* self,
                                          char** argv);
