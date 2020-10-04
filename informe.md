## PASO 0

b)  Valgrind es una herramienta que nos permite identificar problemas al momento de utilizar memoria dinamica. Por ejemplo, memoria no liberada, el uso de memoria no inicializada, etc.
    Es importante aclarar que la compilacion realizada con Valgrind es mucho mas lenta, con lo cual solo se realiza cuando se intenta algun error del tipo mencionado en el parrafo anterior, o relacionados.

c) **sizeof()** representa la cantidad de bytes que ocupa en memoria el valor pasado por parametro. El valor de salida de **sizeof(char)** sera 1, y el valor de salida de **sizeof(int)**, 4. Esto es asi por que los valores cuyo tipo de dato son *char* e *int* ocupan 1 y 4 bytes respectivamente en memoria.

d) El **sizeof()** de una struct en C **no** es igual a la suma de los **sizeof()** de cada uno de sus elementos. Un ejemplo de esto (que fue dado en clase) es un tipo de struct que este compuesto de cuatro valores (int, char, int, char). A pesar de que la suma de los **sizeof()** de los elementos da como resultado 10 (4+1+4+1 = 10), luego de cada char quedan tres bytes libres debido al padding, y por lo tanto se desperdicia memoria. Este concepto prioriza la *performance* del programa por sobre la memoria. El resultado es que el struct dado como ejemplo ocupa 16 bytes (4 por cada dato).

e) STDIN, STDOUT y STDERR son variables de tipo FILE* (punteros a archivos). Tienen como objetivo almacenar un puntero hacia la direccion de memoria que contiene la entrada estandar (donde se ingresan datos, por defecto el teclado), la salida estandar (donde se muestran los datos, por defecto la pantalla, mas especificamente la consola) y la salida de errores estandar (donde se muestran los mensajes de errores, por defecto es igual a la salida estandar), respectivamente.

## PASO 1

a) Los problemas de estilo detectados son aquellos indicados abajo del titulo "Verificando el codigo...". Abajo explicare cada uno de ellos:

* La primera linea nos indica que en la linea 27 del archivo "paso1_wordscounter.c" falta un espacio entre *while* y la apertura de parentesis con la condicion para ese *while*.
* La segunda y tercera linea nos indican que en la linea 41 del archivo "paso1_wordscounter.c", la cantidad de espacios entre la apertura de parentesis y el inicio de la sentencia de condicion es distinta a la cantidad de espacios entre el fin de la sentencia de condicion y el parentesis de cierre, y por otro lado, que esta cantidad de espacios solo puede ser cero o uno.
* La cuarta y la quinta linea nos indican que en la linea 47 del archivo "paso1_wordscounter.c", la proxima sentencia *else* o *else if* deberia aparecer en la misma linea que la llave que cierra el codigo de la anterior sentencia *if* o *else if*, asi como tambien que, si un *else* tiene una llave de un lado de la sentencia, debe tenerlo en ambos.
* La sexta linea nos indica que en la linea 48 del archivo "paso1_wordscounter.c" ocurre lo mismo que en el error de la linea 27 pero con una sentencia *if*: falta un espacio entre *if* y la apertura de parentesis con la condicion para ese *if*.
* La septima linea nos indica que en la linea 53 del archivo "paso1_wordscounter.c" hay un espacio entre el fin de la sentencia de la linea y el punto y coma que determina ese fin de linea.
* La octava linea nos indica que la linea 5 del archivo "paso1_wordscounter.h" tiene mas de 80 caracteres de largo.
* La novena linea nos indica que en la linea 12 del archivo "paso1_main.c" es mejor utilizar la funcion *snprintf* antes que *strcpy*.
* La novena linea nos indica que en la linea 12 del archivo "paso1_main.c"
* La decima y undecima linea nos indican que en la linea 15 de archivo "paso1_main.c" ocurre lo mismo que mencionamos en los errores de la cuarta y quinta linea.

b) Los errores de generacion del ejecutable son los indicados abajo del titulo "Desempaquetando y compilando el codigo...". Abajo explicare cada uno de ellos:

* La primera linea nos indica que en la linea 22 del archivo "paso1main.c" se intenta declarar una variable *counter* de tipo desconocido (*wordscounter_t*).
* De la segunda a la quinta linea nos indican que en las lineas 23, 24, 25 y 27 del archivo "paso1main.c" se utilizan funciones que no estan declaradas ni definidas en ningun lado (probablemente por falta de un *include*).

   Los errores parecen estar asociados al compilador, no al linker, ya que el proceso de compilacion ocurre antes del de linkedicion. Al producirse errores en la compilacion, la linkedicion nunca llega a realizarse.

c) No parecen haberse reportado *warnings*.
	
	
