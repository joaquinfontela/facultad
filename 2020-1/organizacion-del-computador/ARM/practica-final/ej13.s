    .data
numero:
    .word   7

    .text

    .global _start              @ buena practica, no es obligatorio.

_start:
    ldr     r0, =numero
    ldr     r0, [r0]
    mov     r1, #1

    bl      factorial

    bl      printIntegerInR1

factorial:
    stmfd   sp!, {lr}
    cmp     r0, #1
    beq     factorialOf1
    sub     r0, r0, #1
    bl      factorial
    add     r0, r0, #1
    mul     r1, r1, r0
    b       factorialEnd

factorialOf1:
    mov     r1, #1

factorialEnd:
    ldmfd   sp!, {pc}

printIntegerInR1:
    mov     r0, #1
    swi     0x6b

endProgram:
    swi     0x11                @ finaliza el prog

    .end