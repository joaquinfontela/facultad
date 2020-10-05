    .data

    .text

    .global _start                  @ buena practica, no es obligatorio.

_start:
    mov     r0, #-4             @ muevo al r0 el valor numerico al cual le quiero calcular su abs, no lo cargo desde un arch.

    cmp     r0, #0

    movmi   r1, #-1
    eormi   r0, r0, r1
    addmi   r0, r0, #1 

    mov     r1, r0
    mov     r0, #1
    swi     0x6b                

    swi     0x11                @ finaliza el prog

    .end