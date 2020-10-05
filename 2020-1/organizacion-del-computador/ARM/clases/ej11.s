    .data

    .text

    .global _start                  @ buena practica, no es obligatorio.

_start:
    mov     r2, #0

imprimirProximoNumero:
    mov     r0, #1
    mov     r1, r2
    swi     0x6b

verificarProximaIteracion:
    add     r2, r2, #1
    cmp     r2, #10
    bmi     imprimirProximoNumero

finalizarPrograma:
    swi     0x11                

    .end