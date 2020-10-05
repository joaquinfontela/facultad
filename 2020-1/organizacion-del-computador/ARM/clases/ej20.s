    .equ    SWI_EXIT, 0x11
    .equ    SWI_PRINT_INT, 0x6b
    .equ    SWI_PRINT_cHAR, 0x00
    .data
arr:
    .word   17, 31, 59, -8, 43, 91, -4, 34
longArr:
    .word   8

    .text

    .global _start                  @ buena practica, no es obligatorio.

_start:
    ldr     r2, =arr                @ me guardo el comienzo del array en r2.
    ldr     r3, =longArr            
    ldr     r3, [r3]                @ guardo en r3 la cantidad de iteraciones restantes.
    ldr     r4, [r2]                @ en r4 voy a guardar el minimo valor del vector.

proxIteracion:
    sub     r3, r3, #1

    ldr     r0, [r2]
    cmp     r0, r4  
    movmi   r4, r0 

    cmp     r3, #0
    beq     imprimirResultado

    add     r2, r2, #4
    b       proxIteracion 

imprimirResultado:
    mov     r0, #1
    mov     r1, r4
    swi     0x6b

finalizarPrograma:
    swi     SWI_EXIT                

    .end