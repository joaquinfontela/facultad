    .data

    .text

    .global _start                  @ buena practica, no es obligatorio.

_start:
    @ hardcodeo los dos valores, no los leo desde el arch.
    mov     r0, #-11            
    mov     r1, #5

guardarMayorValorEnR2YMenorEnR3:
    cmp     r0, r1          @ comparo r0 y r1, seteando los flags.
    bmi     r0EsMenor

    mov     r2, r0
    mov     r3, r1
    b       finalizarPrograma

r0EsMenor:           
    mov     r3, r0             
    mov     r2, r1 

finalizarPrograma:              
    swi     0x11                @ finaliza el prog

    .end