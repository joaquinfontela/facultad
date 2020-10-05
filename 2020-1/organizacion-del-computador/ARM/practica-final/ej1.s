    .data
mensaje:
    .asciz "Hola mundo\n"

    .text

    .global _start                  @ buena practica, no es obligatorio.

_start:
    ldr     r0, =mensaje
    swi     0x02

    swi     0x11                @ finaliza el prog

    .end