    .data
fileName:
    .asciz "ej4.txt"

inFileHandle:
    .word  0

    .text

    .global _start                  @ buena practica, no es obligatorio.

_start:

openFile:
    ldr     r0, =fileName
    mov     r1, #0
    swi     0x66

readInteger:
    swi     0x6c

printInteger:
    mov     r1, r0
    mov     r0, #1
    swi     0x6b

closeFile:
    ldr     r0, =fileName
    ldr     r0, [r0]
    swi     0x68

endProgram:
    swi     0x11                @ finaliza el prog

    .end