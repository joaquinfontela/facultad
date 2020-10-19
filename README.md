# INFORME DEL TRABAJO PRACTICO 1 

## INTRODUCCION

El informe que leera a continuacion explicara el proceso de desarrollo del Trabajo Practico numero 1 de Taller de Programacion I.
En este, se nos pidio realizar un programa que permitiera establecer una comunicacion entre dos procesos locales. Para esto, tuve que implementar el TDA Socket, para poder enviar y recibir mensajes. 
Ademas, se pidio cifrar los mensajes del lado del cliente (el cifrado podia realizarse mediante tres metodos: Cesar, RC4 o Vigenere), para luego enviarlos, recibirlos del lado del servidor y descifrarlos. Por lo tanto, tambien tuve que implementar los TDAs respectivos a cada metodo de cifrado.
Finalmente, para ejecutar el programa se pidio un formato especifico de comando. Por esta razon , hubo que implementar tanto un validador de comando, como un posterior *parser* para poder extraer los valores de los campos ingresados en el comando.


## DESARROLLO DEL TRABAJO   

#### IDENTIFICACION DE LOS TDA A IMPLEMENTAR

Ante todo, decidi identificar aquellos "objetos" necesarios para el funcionamiento del programa. A excepcion del cifrador general (que se comunica con cada uno de los tres cifradores particulares), todos los demas TDAs incluidos en el trabajo final habian sido planeados desde el comienzo.

#### PRIMERAS LINEAS DE CODIGO

Luego, toco comenzar a *codear*. Comence implementando los TDAs correspondientes a los cifradores (de ahora en mas, *encoders*), para luego continuar con el validador y el *parser* del comando de ejecucion.
En esta primera etapa, no hubo mayores dificultades (aunque posteriormente, comprobe que hizo falta mayor cantidad de pruebas de casos borde).

#### DESARROLLO DE SOCKETS

Esta fue la parte que mas me costo del trabajo. Por un lado, porque nunca habia trabajado con sockets, y tuve que "absorber" todos los conocimientos relacionados a ellos en poco tiempo, para luego aplicarlos. Ademas, durante el desarrollo, no podia ir probando las primitivas que le implementaba al TDA Socket.
Mi poco conocimiento del tema fue llevado hasta las ultimas consecuencias, ya que un error en la implementacion fue la ultima correccion que tuve que realizar para poder pasar las pruebas del SERCOM.

#### UNIFICACION DEL PROYECTO

En esta ultima etapa, toco desarrollar ambas funciones *main* (tanto la del *client* como la del *server*) y hacer trabajar en ellas a todas las partes del proyecto de manera conjunta. Aca fue cuando decidi crear el TDA *common_encoder*, para encapsular el funcionamiento del cifrado.

#### DEBUGGING CONTINUO

Durante todo el proyecto hizo falta *debuggear* ya que las fallas de compilacion (principalmente debido a que tratamos todos los *warnings* como errores) eran frecuentes. El *debugging* mas intenso se dio en dos momentos: por un lado, durante la implementacion de TDA Socket; por el otro, al realizar la entrega en el SERCOM, ya que tuve errores simples como tener *hardcodeados* el *host* y *port*, como otros mas complejos de identificar.


## HERRAMIENTAS UTILIZADAS

##### VISUAL STUDIO CODE
Fue el IDE utilizado por mi durante todo el proyecto.

##### GDB 
Intente utilizar este *debugger* para identificar un *bug* que no estaba pudiendo encontrar pero no me fue de utilidad (tal vez, por mi poca experiencia con esta herramienta). Creo que para el proximo TP deberia investigarla mas a fondo, ya que mas temprano que tarde seguramente la terminare necesitando.

##### VALGRIND
Para identificar *leaks* de memoria. No lo corri muchas veces, ya que no me hizo falta (solo una vez encontre fallas, y las solucione *debuggeando* otra cosa).

##### LINEA DE COMANDOS
No fue un proyecto en el que haya crecido de gran manera mi conocimiento acerca de la terminal. Pero si me permitio familiarizarme un poco mas con ella, como cada vez que toca utilizarla.