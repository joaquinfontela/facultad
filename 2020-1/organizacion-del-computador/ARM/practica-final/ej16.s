    .data
arr:
    .word   3, -7, -11, 0

    .text

    .global _start                  @ buena practica, no es obligatorio.

_start:
    ldr     r1, =arr
    mov     r2, #4

proxElem:
    bl      printIntegerInMemoryAdressSavedInR1

    sub     r2, r2, #1
    cmp     r2, #0
    beq     endProgram

    add     r1, r1, #4
    b       proxElem

printIntegerInMemoryAdressSavedInR1:
    stmfd   sp!, {r1, lr}
    mov     r0, #1
    ldr     r1, [r1]
    swi     0x6b
    ldmfd   sp!, {r1, pc}

endProgram:
    swi     0x11                @ finaliza el prog

    .end