## PASO 0

a) ![Hola](https://github.com/joaquinfontela/recursos-taller/blob/master/sreenshot0.png)

b)  	Valgrind es una herramienta que nos permite identificar problemas al momento de utilizar memoria dinamica. Por ejemplo, memoria no liberada, el uso de memoria no inicializada, etc.
    	Es importante aclarar que la compilacion realizada con Valgrind es mucho mas lenta, con lo cual solo se realiza cuando se intenta algun error del tipo mencionado en el parrafo anterior, o relacionados.

c) 	**sizeof()** representa la cantidad de bytes que ocupa en memoria el valor pasado por parametro. El valor de salida de **sizeof(char)** sera 1, y el valor de salida de **sizeof(int)**, 4. Esto es asi por que los valores cuyo tipo de dato son *char* e *int* ocupan 1 y 4 bytes respectivamente en memoria.

d) 	El **sizeof()** de una struct en C **no** es igual a la suma de los **sizeof()** de cada uno de sus elementos. Un ejemplo de esto (que fue dado en clase) es un tipo de struct que este compuesto de cuatro valores (int, char, int, char). A pesar de que la suma de los **sizeof()** de los elementos da como resultado 10 (4+1+4+1 = 10), luego de cada char quedan tres bytes libres debido al padding, y por lo tanto se desperdicia memoria. Este concepto prioriza la *performance* del programa por sobre la memoria. El resultado es que el struct dado como ejemplo ocupa 16 bytes (4 por cada dato).

e) 	STDIN, STDOUT y STDERR son variables de tipo FILE* (punteros a archivos). Tienen como objetivo almacenar un puntero hacia la direccion de memoria que contiene la entrada estandar (donde se ingresan datos, por defecto el teclado), la salida estandar (donde se muestran los datos, por defecto la pantalla, mas especificamente la consola) y la salida de errores estandar (donde se muestran los mensajes de errores, por defecto es igual a la salida estandar), respectivamente.

## PASO 1

a) 	Los problemas de estilo detectados son aquellos indicados abajo del titulo "Verificando el codigo...". Abajo explicare cada uno de ellos:

(screenshot 1)

* La primera linea nos indica que en la linea 27 del archivo "paso1_wordscounter.c" falta un espacio entre *while* y la apertura de parentesis con la condicion para ese *while*.
* La segunda y tercera linea nos indican que en la linea 41 del archivo "paso1_wordscounter.c", la cantidad de espacios entre la apertura de parentesis y el inicio de la sentencia de condicion es distinta a la cantidad de espacios entre el fin de la sentencia de condicion y el parentesis de cierre, y por otro lado, que esta cantidad de espacios solo puede ser cero o uno.
* La cuarta y la quinta linea nos indican que en la linea 47 del archivo "paso1_wordscounter.c", la proxima sentencia *else* o *else if* deberia aparecer en la misma linea que la llave que cierra el codigo de la anterior sentencia *if* o *else if*, asi como tambien que, si un *else* tiene una llave de un lado de la sentencia, debe tenerlo en ambos.
* La sexta linea nos indica que en la linea 48 del archivo "paso1_wordscounter.c" ocurre lo mismo que en el error de la linea 27 pero con una sentencia *if*: falta un espacio entre *if* y la apertura de parentesis con la condicion para ese *if*.
* La septima linea nos indica que en la linea 53 del archivo "paso1_wordscounter.c" hay un espacio entre el fin de la sentencia de la linea y el punto y coma que determina ese fin de linea.
* La octava linea nos indica que la linea 5 del archivo "paso1_wordscounter.h" tiene mas de 80 caracteres de largo.
* La novena linea nos indica que en la linea 12 del archivo "paso1_main.c" es mejor utilizar la funcion *snprintf* antes que *strcpy*.
* La novena linea nos indica que en la linea 12 del archivo "paso1_main.c"
* La decima y undecima linea nos indican que en la linea 15 de archivo "paso1_main.c" ocurre lo mismo que mencionamos en los errores de la cuarta y quinta linea.

b) 	Los errores de generacion del ejecutable son los indicados abajo del titulo "Desempaquetando y compilando el codigo...". Abajo explicare cada uno de ellos:

(screenshot 1)

* La primera linea nos indica que en la linea 22 del archivo "paso1main.c" se intenta declarar una variable *counter* de tipo desconocido (*wordscounter_t*).
* De la segunda a la quinta linea nos indican que en las lineas 23, 24, 25 y 27 del archivo "paso1main.c" se utilizan funciones que no estan declaradas ni definidas en ningun lado (probablemente por falta de un *include*).

   	Los errores parecen estar asociados al compilador, no al linker, ya que el proceso de compilacion ocurre antes del de linkedicion. Al producirse errores en la compilacion, la linkedicion nunca llega a realizarse.

c) 	No parecen haberse reportado *warnings*.

## PASO 2

a) 	Las correcciones realizadas son, por un lado, las de problemas de estilo, ya que como podemos ver en el *screenshot* del ejercicio b), no se encontro ninguno. Por otro lado, se resolvieron los errores de generacion del ejecutable anteriores (aunque aparecieron nuevos) gracias a la linea 4, que incluye al archivo "paso2_wordscounter.h".

b) (screenshot 3)

c) (screenshot 4)

Los errores de generacion del ejecutable mostrados arriba tienen su explicacion a continuacion:

* El primer y el segundo error nos indican que en "paso2wordscounter.h", se utiliza un tipo **size_t** que no esta definido.
* El tercer error nos indica la solucion al problema anterior: se nos olvido incluir el modulo "stddef.h" (el *ifndef* evita que se vuelva a incluir en caso de ya estar definido en alguno de los modulos incluidos).
* El cuarto y el quinto error presentan un problema similar al anterior: la cuarta nos indica que **FILE** no es un tipo valido, sin embargo, en la quinta linea se nos da la solucion: debemos incluir el modulo "stdio.h". 
* El sexto y el septimo error estan relacionados al primero, como **size_t** no esta incluido en el archivo "paso2wordscounter.h", se genera un conflicto de tipos entre el ".c" y el ".h".
* El octavo, noveno y decimo error ocurren debido a que la funcion *malloc* no esta definida, por lo tanto, la toma como si fuera una declaracion implicita. Nos ofrece como solucion, o bien definirla, o incluirla mediante la libreria "stdlib.h".

   	Los errores nuevamente parecen estar asociados al compilador, no al linker, ya que el proceso de compilacion ocurre antes del de linkedicion. Al producirse errores en la compilacion, la linkedicion nunca llega a realizarse.

## PASO 3

a) La diferencia con el paso anterior es la inclusion de las librerias que generaban los problemas antes mencionados.

b) (screenshot 6)

En este caso, podemos observar que el error se produce en un modulo llamado "paso3_main.o", es decir, contiene codigo objeto. Esto quiere decir que la compilacion se realizo correctamente (ya que justamente tiene como objetivo transformar el codigo en lenguaje de alto nivel a codigo objeto). Sin embargo, fallo la linkedicion, debido a que hay una referencia a "wordscounter__destroy", funcion que si buscamos en el archivo ".c", nunca esta definida (si esta declarada en el archivo ".h").

## PASO 4

a) La unica diferencia con la version anterior es la definicion de "wordscounter__destroy".

b) (screenshots 7 y 8)

* El primer error visible es que en "paso4_main.c" se realiza la apertura de un archivo en la linea 14 con *fopen*, pero nunca se realiza el cierre de ese archivo.
* Luego, tambien relacionado con la apertura del archivo, en la linea 10 se declara una variable *input* de tipo **FILE*** a la que luego se le asigna el valor devuelto por *fopen*, esa memoria nunca es liberada.
* Finalmente, en "paso4wordscounter.c", en la linea 35 se realiza un malloc, cuyo puntero es *delim_words*, esa memoria tampoco es liberada en ninguna parte.

c) (screenshot 9)

* En el caso de "nombre_largo", el error es un *buffer overflow*, que ocurre porque la funcion *memcpy* recibe en uno de los parametros la cantidad de bytes a copiar. En este caso, el destino de la copia es un array con 30 bytes reservados de memoria: si la cantidad de bytes a copiar es mayor, se produce un *overflow*.

d) Si, se puede solucionar, ya que *strncpy* nos permite definir un limite de bytes (el tamano del destino usualmente) a ser utilizados. En caso de usar *strncpy*, la prueba hubiera pasado, ya que si le enviamos mas bytes de lo estipulado a la funcion, simplemente ignora los sobrantes.

e) Un *segmentation fault* se produce cuando intentamos acceder a una zona de memoria sin los permisos necesarios (ya sea para lectura, escritura o ejecucion, segun corresponda). Por otro lado, un *buffer overflow* ocurre cuando teniamos reservada una zona de memoria (un buffer, justamente) y cargamos a esta datos de mayor tamano al tamano reservado, sobreescribiendo zonas de memoria por fuera del buffer.

## PASO 5

a) Las correcciones realizadas son las siguientes:

* Por un lado, en "paso5wordscounter.c", se reemplaza el malloc y la definicion caracter a caracter de la variable *delim_words* por una unica linea donde se hace lo mismo, pero sin reservar memoria mediante malloc.
* Por otro lado, se agrega el *fclose* en el "paso5_main.c", de manera de cerrar el archivo luego de finalizar su uso.
* Finalmente, se reemplaza la copia de *argv[1]* a *filepath* mediante *memcpy*, y directamente se le pasa como parametro a *fopen* el primer argumento pasado por la linea de comando.

b) Los motivos por los que fallan las pruebas seran detallados a continuacion:

* *Invalid File* no falla porque el manejo en caso de un archivo invalido este mal. El fallo se da porque en el programa, el error esta definido como valor de retorno -1, mientras que el test espera el valor 1.
* Por otro lado, *Single word* falla debido a que en *"paso5_wordscounter.c"* la funcion *wordscounter_next_state_* suma una palabra al contador cuando el estado actual es *IN_WORD* y el proximo caracter esta entre los definidos como delimitantes. Sin embargo, esto genera que no se tenga en cuenta la ultima palabra cuando el ultimo caracter del archivo de texto no es uno de los delimitantes. Podemos ver que en el caso del archivo de texto de dos palabras, este finaliza con un salto de linea (que si esta entre los caracteres delimitantes), mientras que en *Single Word* el ultimo caracter es una letra "d".

SERcOM nos aporta aquel valor de retorno del test, junto con el esperado por la prueba.

c) (screenshot 10)

d) (screenshot 11)

* *info functions* nos muestra las firmas de todas las funciones.
* *list wordscounter_next_state* imprime las lineas cercanas a la definicion de la funcion *wordscounter_next_state*.
* *list* imprime las siguientes lineas a las impresas con el ultimo comando *list* utilizado.
* *break 45* coloca un breakpoint en la linea 45.
* *run input_single_word.txt* corre el programa siendo el archivo *input_single_word.txt* el parametro.

El programa no se detiene en la linea 45 tal como habiamos pedido porque nunca se ejecuta esa instruccion, ya que alli se suma una palabra al contador, pero la cantidad de palabras contadas es 0.

## PASO 6

a) Las correcciones con respecto al paso anterior son las siguientes:

* Se define el valor de retorno de error en 1, en vez de -1.
* Se define el array de caracteres delimitadores como una variable de preprocesador con *#define*.
* Se agrega la condicion de que, en caso de que se llegue al final del archivo, y el estado sea *IN_WORD*, se define el estado como finalizado y se suma uno al contador.

b) (screenshot 12)

c) (screenshot 13)
	
