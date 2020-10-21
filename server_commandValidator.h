#include <ctype.h>
#include <stdbool.h>
#include <stdio.h>
#include <string.h>

typedef struct serverCommandValidator {
  int argc;
  char** argv;
} serverCommandValidator_t;

/*  Pre:          argc = el contador de argumentos del comando en la terminal.
 *                argv = el vector de argumentos del comando en la terminal.
 *
 *
 *  Pos:          Inicializa el validador de comando.
 *
 *  RETURN VALUE: -1 en caso de error, 0 en caso de exito.
 *
 */
int serverCommandValidator_initialize(serverCommandValidator_t* self, int argc,
                                      char** argv);

/*  Pos:          Valida el vector de argumentos recibido por linea de comandos.
 *
 *  RETURN VALUE: false en caso de ser invalido, true en caso de ser valido.
 *
 */
bool serverCommandValidator_t_commandIsValid(serverCommandValidator_t* self);
