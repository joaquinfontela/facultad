    .data
arr:
    .word   3, -7, -11, 0, 7, -21, 1000, 50
length:
    .word   8

    .text

    .global _start                  @ buena practica, no es obligatorio.

_start:
    ldr     r0, =arr
    ldr     r1, =arr
    ldr     r1, [r1]
    ldr     r2, =length
    ldr     r2, [r2]

proxElem:
    sub     r2, r2, #1
    cmp     r2, #0
    beq     printIntegerInR1

    add     r0, r0, #4

    ldr     r3, [r0]
    cmp     r3, r1
    movmi   r1, r3    

    b       proxElem 

printIntegerInR1:
    mov     r0, #1
    swi     0x6b

endProgram:
    swi     0x11                @ finaliza el prog

    .end