#include <stdio.h>
#include <string.h>

#include "common_cesar.h"
#include "common_rc4.h"
#include "common_vigenere.h"

typedef struct encoder {
  uint8_t* method;
  uint8_t* key;
  cesarEncoder_t cesarEncoder;
  vigenereEncoder_t vigenereEncoder;
  rc4Encoder_t rc4Encoder;
} encoder_t;

/*  Pre:          method = una cadena de caracteres con el nombre del encoder.
 *                key = una cadena de caracteres con la llave de encodeo.
 *
 *  Pos:          Se guarda el method y la llave para encodear en el struct, y
 *                ademas crea los tres encoders para tambien guardarselos.
 *
 *
 *  RETURN VALUE: 1 en caso de error, 0 en caso de exito.
 *
 */
int encoder_t_init(encoder_t* self, uint8_t* method, uint8_t* key);

/*  Pre:          string = el mensaje a ser cifrado.
 *
 *  Pos:          Deja en 'string' el mensaje recibido pero ya cifrado.
 *
 *
 *  RETURN VALUE: 1 en caso de error por parametro nulo, 2 en caso de error por
 *                metodo de cifrado no valido, 0 en caso de exito.
 *
 */
int encoder_t_encode(encoder_t* self, uint8_t string[]);

/*  Pre:          string = el mensaje a ser descifrado.
 *                bytesToDecode = la cantidad de bytes a ser descifrados (el
 *                largo del mensaje).
 *
 *  Pos:          Deja en 'string' el mensaje descifrado.
 *
 *  RETURN VALUE: 1 en caso de error por parametro nulo, 2 en caso de error por
 *                metodo de cifrado no valido, 0 en caso de exito.
 *
 */
int encoder_t_decode(encoder_t* self, uint8_t string[], uint32_t bytesToDecode);
