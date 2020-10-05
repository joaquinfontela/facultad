    .equ    SWI_EXIT, 0x11
    .equ    SWI_PRINT_INT, 0x6b
    .equ    SWI_PRINT_cHAR, 0x00
    .data
arr:
    .word   17, 31, 59, -8, 43, 91, -4, 34
longArr:
    .word   8
constanteDeSuma:
    .word   20
newArr:
    .skip   8 * 4

    .text

    .global _start                  @ buena practica, no es obligatorio.

_start:
    ldr     r2, =arr                @ me guardo el comienzo del array en r2.
    ldr     r3, =longArr            
    ldr     r3, [r3]                @ guardo en r3 la cantidad de iteraciones restantes.
    ldr     r4, =constanteDeSuma
    ldr     r4, [r4]                @ guardo en r4 la constante a sumar a cada valor del vector.
    ldr     r5, =newArr             @ me guardo el comienzo del nuevo array en r5.

proxPosicion:
    sub     r3, r3, #1

    ldr     r0, [r2]
    add     r0, r0, r4
    str     r0, [r5]  

    cmp     r3, #0
    beq     imprimirNuevoVector

    add     r2, r2, #4
    add     r5, r5, #4
    b       proxPosicion 

imprimirNuevoVector:                @ esto no fue pedido, pero me sirve como verificacion (esta copiado del ej 16).
    ldr     r2, =newArr             
    ldr     r3, =longArr
    ldr     r3, [r3]                  

proxIteracion:
    sub     r3, r3, #1

    mov     r0, #1
    ldr     r1, [r2]
    swi     SWI_PRINT_INT     

    cmp     r3, #0
    beq     finalizarPrograma

    add     r2, r2, #4
    b       proxIteracion 

finalizarPrograma:
    swi     SWI_EXIT                 

    .end