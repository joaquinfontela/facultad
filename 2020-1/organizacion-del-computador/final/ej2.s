    .data
array:
    .word   3, -7, -11, 0, 7, -21, 1000, 50, 37, 94

    .text

    .global _start                  

_start:
    ldr     r0, =array          @ guardo la direccion de memoria de inicio del array en r0.

addOffset:
    add     r0, r0, #8          @ luego, a la direccion de memoria le sumo un offset de valor 8.
                                @ de esta manera, como cada posicion del array es de tamano 4, me movere dos posiciones.

saveValue:
    ldr     r1, [r0]            @ guardo el valor almacenado en la direcc. de memoria a la que apunta r0 en r1.

printValue:
    mov     r0, #1
    swi     0x6b                @ imprimo el valor (el tercer valor del array.)

endProgram:
    swi     0x11                

    .end