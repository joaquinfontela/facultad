#include <stdio.h>

#include "client_commandValidator.h"

typedef struct clientCommandParser {
  char* host;
  char* port;
  char* method;
  char* key;
} clientCommandParser_t;

/*  Pre:          self = un puntero a clientCommandParser_t no inicializado.
 *                argv = el vector de argumentos del comando en la terminal.
 *
 *
 *  Pos:          Inicializa el parser.
 *
 *  RETURN VALUE: -1 en caso de error, 0 en caso de exito.
 *
 */
int clientCommandParser_t_initialize(clientCommandParser_t* self, char** argv);

/*  Pre:          argv = el vector de argumentos del comando en la terminal.
 *
 *
 *  Pos:          Se guarda los valores ingresados por linea de comando
 *                de host, port, method y key en el struct.
 *
 *  RETURN VALUE: -1 en caso de error, 0 en caso de exito.
 *
 */
void clientCommandParser_t_parseArguments(clientCommandParser_t* self,
                                          char** argv);
