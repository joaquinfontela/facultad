# INFORME DEL TRABAJO PRACTICO 3

## INTRODUCCION

El informe que leera a continuacion explicara el proceso de desarrollo del Trabajo Practico numero 3 de Taller de Programacion I.
En este, se nos pidio realizar una aplicacion servidor que atendiera petitorios HTTP (unicamente metodos GET y POST) de multiples clientes, pudiendo procesarlos y respondiendo a los clientes con un resultado.
Ademas, se nos impusieron ciertas restricciones, como la aplicacion obligatoria de polimorfismo en las respuestas del servidor, la sobrecarga del operador **()** en alguna clase, y la limpieza de clientes finalizados cada vez que se conecta uno nuevo.

## DESARROLLO DEL TRABAJO

#### IDENTIFICACION DE LAS CLASES A IMPLEMENTAR

Ante todo, se decidio identificar aquellas "clases" necesarias para el funcionamiento del programa. Estas se fueron implementando a medida que iban necesitandose en el programa. Primero las relacionadas al parseo y validacion del comando, luego las de parseo del protocolo HTTP, mas tarde las relacionadas a los *sockets*, y por ultimo las relacionadas a los *threads*.

#### PRIMERAS LINEAS DE CODIGO

Toco entonces comenzar a _codear_. Luego de implementar el parser del comando, algo bastante simple, se prosiguio implementando las clases correspondientes al parser del protocolo HTTP, para poder guardarnos los valores que nos interesaban (*method*, *resource* y *body*).
En esta primera etapa, no hubo mayores dificultades, aunque hubo que realizar un ligero cambio ya que en un principio yo parseaba el archivo en el cliente y mandaba los datos, y luego me entere que habia que enviar el contenido del archivo por sockets, para luego parsear la *string* en el servidor.

#### DESARROLLO DE LOS SOCKETS 

Esta parte no trajo mayores problemas ya que ya teniamos los *sockets* implementados del TP1, solo hacian falta ligeros cambios (mas luego agregar un par de metodos mas segun pude ver) con respecto a los de C.

#### DESARROLLO DE LOS THREADS

Se utilizo como base la implementacion del cuatrimestre pasado de la catedra, al igual que en el TP2. Sin embargo, en este caso la logica era un poco mas compleja ya que dos clases distintas hacian uso de los *threads* (*SingleClientHandler*, que administraba una peticion de un cliente particular, y *ClientManager*, que hacia uso del socket aceptador y de eliminador de sockets cuyos procesos hubieran finalizado).
Luego, se agrego un _mutex_ en la zona critica correspondiente a la clase compartida por los _threads_.

#### DEBUGGING CONTINUO

Durante todo el proyecto hizo falta _debuggear_ ya que las fallas de compilacion (principalmente debido a que tratamos todos los _warnings_ como errores) eran frecuentes. El _debugging_ mas intenso se dio durante la unificacion de las distintas partes del proyecto.

## HERRAMIENTAS UTILIZADAS

##### VISUAL STUDIO CODE

Fue el IDE utilizado durante todo el proyecto.

##### CLION

Utilizado en muy pocos momentos especificos para refactorizaciones grandes que queria realizar de manera automatica.

##### GDB

Se intento utilizar este _debugger_ para identificar un _bug_ que no se estaba pudiendo encontrar pero no fue de utilidad (tal vez, por la poca experiencia con esta herramienta).

##### VALGRIND

Para identificar _leaks_ de memoria. Fue muy util para detectar el ultimo error pre-entrega en el SERCOM (relacionado con un *memory leak* debido a un mal uso del polimorfismo en la respuesta del servidor, inicializando mal un objeto).

## DIAGRAMA DE CLASES

A continuacion, diagramas de clases representativos de este proyecto.

#### DIAG

![](https://github.com/joaquinfontela/tp3-taller/blob/master/utils/diagrama1.jpeg)

#### DIAG

![](https://github.com/joaquinfontela/tp3-taller/blob/master/utils/diagrama5.jpeg)

#### DIAG

![](https://github.com/joaquinfontela/tp3-taller/blob/master/utils/diagrama6.jpeg)

#### DIAG

![](https://github.com/joaquinfontela/tp3-taller/blob/master/utils/diagrama2.jpeg)

#### DIAG

![](https://github.com/joaquinfontela/tp3-taller/blob/master/utils/diagrama3.jpeg)

#### DIAG

![](https://github.com/joaquinfontela/tp3-taller/blob/master/utils/diagrama4.jpeg)


## CONCLUSIONES

- Se produjo un primer acercamiento a un tema tan importante como protocolos HTTP.
- Se profundizo en las bases de la programacion orientada a objetos (sobre todo en encapsulamiento).
- Se profundizo en el uso de *threads* y *sockets*, sobre todo por utilizarlos de manera conjunta.
- Avance importante en la utilizacion de C++.
