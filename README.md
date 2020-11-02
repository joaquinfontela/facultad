# INFORME DEL TRABAJO PRACTICO 2

## INTRODUCCION

El informe que leera a continuacion explicara el proceso de desarrollo del Trabajo Practico numero 2 de Taller de Programacion I.
En este, se nos pidio realizar un verificador eBPF, que se basa en determinar si un archivo de codigo Assembly tiene loops o instrucciones sin ejecutar. El programa deberia poder procesar todos los archivos indicados en el comando de ejecucion.
Ademas, se pidio realizar la ejecucion mediante una cantidad **n** threads, tambien definida por parametro en el comando de ejecucion.

## DESARROLLO DEL TRABAJO

#### IDENTIFICACION DE LAS CLASES A IMPLEMENTAR

Ante todo, se decidio identificar aquellas "clases" necesarias para el funcionamiento del programa. A excepcion de la clases _FileGraphData_, las demas clases se fueron implementando a medida que iban necesitandose en el programa. _FileGraphData_ en cambio, fue agregada posteriormente cuando se vio la necesidad de encapsular el funcionamiento conjunto de varios diccionarios.

#### PRIMERAS LINEAS DE CODIGO

Luego, toco comenzar a _codear_. Se comenzo implementando las clases correspondientes al parser y verificador del comando de ejecucion, para luego continuar con las clases relacionadas al Grafo (_DFS_ y _Graph_).
En esta primera etapa, no hubo mayores dificultades (aunque posteriormente, se comprobo que hizo falta mayor cantidad de pruebas de casos borde).

#### DESARROLLO DEL PARSER

Esta fue la parte que mas costo del trabajo debido a su complejidad. Hicieron falta muchas clases con distintas responsabilidades para encapsular esa complejidad. Por un lado habia clases que se encargaban del manejo de la informacion (como _FileGraphData_), mientras que por el otro estaban aquellas encargadas de la logica (como _JumpCommandProcessor_, para procesar instrucciones de tipo _jmp_).

#### DESARROLLO DE LOS THREADS

Se utilizo como base la implementacion del cuatrimestre pasado de la catedra. Luego, hubo que realizar un par de refactorizaciones sobre la logica base para solo tener que utilizar dos _mutex_ (basicamente, juntar la verificacion de si quedan archivos por parsear, con el parseo propio del archivo).
Luego, se agrego un _mutex_ en las dos zonas criticas correspondientes a las dos clases compartidas por los _threads_.

#### DEBUGGING CONTINUO

Durante todo el proyecto hizo falta _debuggear_ ya que las fallas de compilacion (principalmente debido a que tratamos todos los _warnings_ como errores) eran frecuentes. El _debugging_ mas intenso se dio durante la implementacion del parser de archivos.

## HERRAMIENTAS UTILIZADAS

##### VISUAL STUDIO CODE

Fue el IDE utilizado durante todo el proyecto.

##### GDB

Se intento utilizar este _debugger_ para identificar un _bug_ que no se estaba pudiendo encontrar pero no fue de utilidad (tal vez, por la poca experiencia con esta herramienta).

##### VALGRIND

Para identificar _leaks_ de memoria. Fue muy util para detectar el ultimo error pre-entrega en el SERCOM (relacionado con que el constructor del FileParser no inicializaba su atributo _currentLineNumber_ en el constructor).

## DIAGRAMA DE CLASES

A continuacion, diagramas de clases representativos de este proyecto.

#### PARSER

![](https://github.com/joaquinfontela/tp2-taller/blob/master/utils/pictures/diagrama1.png)

#### GRAFO

![](https://github.com/joaquinfontela/tp2-taller/blob/master/utils/pictures/diagrama2.png)

#### GENERAL

![](https://github.com/joaquinfontela/tp2-taller/blob/master/utils/pictures/diagrama3.png)

## CONCLUSIONES

- Se produjo un primer acercamiento a un tema tan importante como _threads_.
- Se profundizo en las bases de la programacion orientada a objetos (sobre todo en encapsulamiento).
- Interesante acercamiento a la utilizacion de grafos para la resolucion de un problema, e implementacion de un parser que transforma un archivo en un grafo.
- Avance importante en la utilizacion de C++.
