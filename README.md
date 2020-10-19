# INFORME DEL TRABAJO PRACTICO 1 

## INTRODUCCION

El informe que leera a continuacion explicara el proceso de desarrollo del Trabajo Practico numero 1 de Taller de Programacion I.
En este, se nos pidio realizar un programa que permitiera establecer una comunicacion entre dos procesos locales. Para esto, se tuvo que implementar el TDA Socket, para poder enviar y recibir mensajes. 
Ademas, se pidio cifrar los mensajes del lado del cliente (el cifrado podia realizarse mediante tres metodos: Cesar, RC4 o Vigenere), para luego enviarlos, recibirlos del lado del servidor y descifrarlos. Por lo tanto, tambien se tuvo que implementar los TDAs respectivos a cada metodo de cifrado.
Finalmente, para ejecutar el programa se pidio un formato especifico de comando. Por esta razon , hubo que implementar tanto un validador de comando, como un posterior *parser* para poder extraer los valores de los campos ingresados en el comando.


## DESARROLLO DEL TRABAJO   

#### IDENTIFICACION DE LOS TDA A IMPLEMENTAR

Ante todo, se decidio identificar aquellos "objetos" necesarios para el funcionamiento del programa. A excepcion del cifrador general (que se comunica con cada uno de los tres cifradores particulares), todos los demas TDAs incluidos en el trabajo final habian sido planeados desde el comienzo.

#### PRIMERAS LINEAS DE CODIGO

Luego, toco comenzar a *codear*. Se comenzo implementando los TDAs correspondientes a los cifradores (de ahora en mas, *encoders*), para luego continuar con el validador y el *parser* del comando de ejecucion.
En esta primera etapa, no hubo mayores dificultades (aunque posteriormente, se comprobo que hizo falta mayor cantidad de pruebas de casos borde).

#### DESARROLLO DE SOCKETS

Esta fue la parte que mas costo del trabajo. Por un lado, porque nunca habia trabajado con sockets, y tuve que "absorber" todos los conocimientos relacionados a ellos en poco tiempo, para luego aplicarlos. Ademas, durante el desarrollo, no era posible ir probando las primitivas que le implementaba al TDA Socket.
El poco conocimiento del tema fue llevado hasta las ultimas consecuencias, ya que un error en la implementacion fue la ultima correccion que se tuvo que realizar para poder pasar las pruebas del SERCOM.

#### UNIFICACION DEL PROYECTO

En esta ultima etapa, toco desarrollar ambas funciones *main* (tanto la del *client* como la del *server*) y hacer trabajar en ellas a todas las partes del proyecto de manera conjunta. Aca fue cuando se decidio crear el TDA *common_encoder*, para encapsular el funcionamiento del cifrado.

#### DEBUGGING CONTINUO

Durante todo el proyecto hizo falta *debuggear* ya que las fallas de compilacion (principalmente debido a que tratamos todos los *warnings* como errores) eran frecuentes. El *debugging* mas intenso se dio en dos momentos: por un lado, durante la implementacion de TDA Socket; por el otro, al realizar la entrega en el SERCOM, ya que hubo errores simples como tener *hardcodeados* el *host* y *port*, como otros mas complejos de identificar.


## HERRAMIENTAS UTILIZADAS

##### VISUAL STUDIO CODE
Fue el IDE utilizado durante todo el proyecto.

##### GDB 
Se intento utilizar este *debugger* para identificar un *bug* que no se estaba pudiendo encontrar pero no fue de utilidad (tal vez, por la poca experiencia con esta herramienta).

##### VALGRIND
Para identificar *leaks* de memoria. No se corrio muchas veces, ya que no hizo falta (solo una vez se encontraron fallas, y se solucionaron *debuggeando* otra cosa).


## DIAGRAMA DE CLASES

A continuacion, dos diagramas de clases representativos de los TDAs implementados para este proyecto.

#### CLIENT

![](https://github.com/joaquinfontela/tp1-taller/blob/master/diagrama-client.jpeg)

#### SERVER

![](https://github.com/joaquinfontela/tp1-taller/blob/master/diagrama-server.jpeg)


## CONCLUSIONES

* Se produjo un primer acercamiento a un tema tan importante como sockets.
* Se profundizo en manejo de memoria, archivos y otras estructuras de datos.
* Interesante acercamiento al cifrado de datos.
* Personalmente, en este proyecto fue la primera vez que implemente un TDA en C. Por lo tanto, realice un gran avance en este lenguaje.
* Una vez implementado el TDA Socket, el TP dismimuyo su dificultad, ya que en la implementacion yacia la parte mas complicada.







