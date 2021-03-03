#include <stdint.h>

typedef struct rc4Encoder {
  uint8_t S[256];
  uint32_t i;
  uint32_t j;
  uint8_t *key;
} rc4Encoder_t;

/*  Pre:          key = la llave con la cual cifrar el mensaje.
 *
 *  Pos:          Se guarda la llave como atributo, ademas de inicializar el
 *                stream y los valores i y j.
 *
 *  RETURN VALUE: -1 en caso de error, 0 en caso de exito.
 *
 */
int rc4Encoder_t_initialize(rc4Encoder_t *self, uint8_t key[]);

/*  Pre:          string = el mensaje a ser cifrado en RC4.
 *
 *  Pos:          Deja en 'string' el mensaje recibido pero ya cifrado.
 *
 */
void rc4Encoder_t_encode(rc4Encoder_t *self, uint8_t string[]);

/*  Pre:          string = el mensaje a ser descifrado en RC4.
 *                bytesToDecode = la cantidad de bytes a ser descifrados (el
 *                largo del mensaje).
 *
 *  Pos:          Deja en 'string' el mensaje recibido pero ya descifrado.
 *
 */
void rc4Encoder_t_decode(rc4Encoder_t *self, uint8_t string[],
                         uint32_t bytesToDecode);
