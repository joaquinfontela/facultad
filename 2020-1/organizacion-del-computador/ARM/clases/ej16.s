    .equ    SWI_EXIT, 0x11
    .equ    SWI_PRINT_INT, 0x6b
    .equ    SWI_PRINT_cHAR, 0x00
    .data
arr:
    .word   17, 31, 59, -8

    .text

    .global _start                  @ buena practica, no es obligatorio.

_start:
    ldr     r2, =arr                @ me guardo el comienzo del array en r2.
    mov     r3, #4                  @ guardo en r3 la cantidad de iteraciones restantes.

proxIteracion:
    sub     r3, r3, #1

    mov     r0, #1
    ldr     r1, [r2]
    swi     SWI_PRINT_INT     

    cmp     r3, #0
    beq     finalizarPrograma

    add     r2, r2, 4
    b       proxIteracion 

finalizarPrograma:
    swi     SWI_EXIT                

    .end