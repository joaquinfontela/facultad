    .equ    SWI_EXIT, 0x11
    .equ    SWI_PRINT_INT, 0x6b
    .data

    .text

    .global _start                  @ buena practica, no es obligatorio.

_start:
    mov     r2, #7      @ valor al cual le calculare el factorial.

factorial:
    mov     r0, #1

elValorEsMayorA0:
    mul     r0, r0, r2

    sub     r2, r2, #1
    cmp     r2, #1
    bpl     elValorEsMayorA0

imprimirResultado:
    mov     r1, r0
    mov     r0, #1
    swi     SWI_PRINT_INT

finalizarPrograma:
    swi     SWI_EXIT                

    .end