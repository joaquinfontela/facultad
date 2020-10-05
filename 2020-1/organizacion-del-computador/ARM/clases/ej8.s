    .data

    .text

    .global _start                  @ buena practica, no es obligatorio.

_start:
    mov     r0, #-11             @ muevo al r0 el valor numerico al cual le quiero calcular su abs, no lo cargo desde un arch.

    cmp     r0, #0
    bpl     imprimirValor       @ voy directamente a imprimir el valor si este es positivo.

    mov     r1, #-1               @ sino, obtengo su opuesto, y lo guardo en r0 para despues imprimirlo.
    eor     r0, r0, r1
    add     r0, r0, #1 

imprimirValor:
    mov     r1, r0
    mov     r0, #1
    swi     0x6b                

    swi     0x11                @ finaliza el prog

    .end