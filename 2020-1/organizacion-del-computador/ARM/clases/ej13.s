    .equ    SWI_EXIT, 0x11
    .equ    SWI_PRINT_INT, 0x6b
    .data

    .text

    .global _start                  @ buena practica, no es obligatorio.

_start:
    mov     r0, #7      @ valor al cual le calculare el factorial.
    mov     r1, #1

factorial:
    stmfd   sp!, {r0, lr}

    cmp     r0, #1
    beq     factorialDe1

    sub     r0, r0, #1

factorialDe1:



finalizarPrograma:
    swi     SWI_EXIT                

    .end