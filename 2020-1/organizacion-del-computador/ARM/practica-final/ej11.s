    .data

    .text

    .global _start                  @ buena practica, no es obligatorio.

_start:
    mov     r1, #0
    bl      printIntegerInR1

    add     r1, r1, #1

    cmp     r1, #10
    beq     endProgram

printIntegerInR1:
    stmfd   sp!, {lr}
    mov     r0, #1
    swi     0x6b
    ldmfd   sp!, {pc}

endProgram:
    swi     0x11                @ finaliza el prog

    .end