    .data
mensaje1:
    .asciz "Hola\n"

mensaje2:
    .asciz "chau\n"

    .text

    .global _start                  @ buena practica, no es obligatorio.

_start:
    ldr     r3, =mensaje1
    bl      printR3
    ldr     r3, =mensaje2
    bl      printR3
    b       finalizarPrograma

printR3:
    stmfd   sp!, {lr}

    mov     r0, r3
    swi     0x02 

    ldmfd   sp!, {pc}

finalizarPrograma:
    swi     0x11                @ finaliza el prog

    .end