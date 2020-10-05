    .data
numero1:
    .word   7
numero2:
    .word   4

    .text

    .global _start                  @ buena practica, no es obligatorio.

_start:
    ldr     r1, =numero1
    ldr     r1, [r1]
    bl      printIntegerInR1

    ldr     r1, =numero2
    ldr     r1, [r1]
    bl      printIntegerInR1

    ldr     r1, =numero1
    mov     r0, #17
    str     r0, [r1]
    ldr     r1, [r1]
    bl      printIntegerInR1

    ldr     r1, =numero2
    mov     r0, #-4
    str     r0, [r1]
    ldr     r1, [r1]
    bl      printIntegerInR1

    b       endProgram

printIntegerInR1:
    stmfd   sp!, {lr}
    mov     r0, #1
    swi     0x6b
    ldmfd   sp!, {pc}

endProgram:
    swi     0x11                @ finaliza el prog

    .end