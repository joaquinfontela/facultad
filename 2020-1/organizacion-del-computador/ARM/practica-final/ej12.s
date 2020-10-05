    .data
numero:
    .word   7

    .text

    .global _start                  @ buena practica, no es obligatorio.

_start:
    ldr     r0, =numero
    ldr     r0, [r0]
    mov     r1, #1

multiply:
    mul     r1, r0, r1

    sub     r0, r0, #1
    cmp     r0, #1
    bne     multiply

printIntegerInR1:
    mov     r0, #1
    swi     0x6b

endProgram:
    swi     0x11                @ finaliza el prog

    .end