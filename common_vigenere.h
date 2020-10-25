#include <stdint.h>

typedef struct vigenereEncoder {
  uint8_t* key;
  uint32_t currentKeyPosition;
} vigenereEncoder_t;

/*  Pre:          key = la llave con la cual cifrar/descifrar el mensaje.
 *
 *  Pos:          Se guarda la llave, ademas inicializa la posicion actual de la
 *                llave en 0.
 *
 *  RETURN VALUE: -1 en caso de error, 0 en caso de exito.
 *
 */
int vigenereEncoder_t_initialize(vigenereEncoder_t* self, uint8_t key[]);

/*  Pre:          string = el mensaje a ser cifrado en Vigenere.
 *
 *  Pos:          Deja en 'string' el mensaje recibido pero ya cifrado.
 *
 */
void vigenereEncoder_t_encode(vigenereEncoder_t* self, uint8_t string[]);

/*  Pre:          string = el mensaje a ser descifrado en Vigenere.
 *                bytesToDecode = la cantidad de bytes a ser descifrados (el
 *                largo del mensaje).
 *
 *  Pos:          Deja en 'string' el mensaje recibido pero ya descifrado.
 *
 */
void vigenereEncoder_t_decode(vigenereEncoder_t* self, uint8_t string[],
                              uint32_t bytesToDecode);
