

b)  Valgrind es una herramienta que nos permite identificar problemas al momento de utilizar memoria dinamica. Por ejemplo, memoria no liberada, el uso de memoria no inicializada, etc.
    Es importante aclarar que la compilacion realizada con Valgrind es mucho mas lenta, con lo cual solo se realiza cuando se intenta algun error del tipo mencionado en el parrafo anterior, o relacionados.

c) **sizeof()** representa la cantidad de bytes que ocupa en memoria el valor pasado por parametro. El valor de salida de **sizeof(char)** sera 1, y el valor de salida de **sizeof(int)**, 4. Esto es asi por que los valores cuyo tipo de dato son *char* e *int* ocupan 1 y 4 bytes respectivamente en memoria.

d) El **sizeof()** de una struct en C **no** es igual a la suma de los **sizeof()** de cada uno de sus elementos. Un ejemplo de esto (que fue dado en clase) es un tipo de struct que este compuesto de cuatro valores (int, char, int, char). A pesar de que la suma de los **sizeof()** de los elementos da como resultado 10 (4+1+4+1 = 10), luego de cada char quedan tres bytes libres debido al padding, y por lo tanto se desperdicia memoria. Este concepto prioriza la *performance* del programa por sobre la memoria. El resultado es que el struct dado como ejemplo ocupa 16 bytes (4 por cada dato).

e) STDIN, STDOUT y STDERR son variables de tipo FILE* (punteros a archivos). Tienen como objetivo almacenar un puntero hacia la direccion de memoria que contiene la entrada estandar (donde se ingresan datos, por defecto el teclado), la salida estandar (donde se muestran los datos, por defecto la pantalla, mas especificamente la consola) y la salida de errores estandar (donde se muestran los mensajes de errores, por defecto es igual a la salida estandar), respectivamente.
