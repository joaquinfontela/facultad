    .equ    SWI_EXIT, 0x11
    .equ    SWI_PRINT_INT, 0x6b
    .equ    SWI_PRINT_cHAR, 0x00
    .data
entero1:
    .word   17

entero2:
    .word   24

    .text

    .global _start                  @ buena practica, no es obligatorio.

_start:

imprimirValoresOriginales:
    ldr     r2, =entero1            @ guarda la direcc de memoria de entero1 en r2
    ldr     r3, =entero2

    bl      imprimirLoQueHayEnLasDireccDeMemoriacontenidasEnR2yR3

imprimirNuevosValores:
    ldr     r2, =entero1
    mov     r1, #99
    str     r1, [r2]                @ guarda el valor de r1, en la direc contenida por r2.

    ldr     r3, =entero2
    mov     r1, #2
    str     r1, [r3]

    bl      imprimirLoQueHayEnLasDireccDeMemoriacontenidasEnR2yR3
    b       finalizarPrograma

imprimirLoQueHayEnLasDireccDeMemoriacontenidasEnR2yR3:
    stmfd   sp!, {lr}

    mov     r0, #1
    ldr     r1, [r2]            @ guarda lo que hay en la direc de memoria contenida en r2, en r1
    swi     SWI_PRINT_INT

    mov     r0, #1
    ldr     r1, [r3]
    swi     SWI_PRINT_INT

    ldmfd   sp!, {pc}

finalizarPrograma:
    swi     SWI_EXIT                

    .end