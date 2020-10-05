    .data
arr:
    .word   3, -7, -11, 0, 7, -21, 1000, 50
length:
    .word   8
newArr:
    .word   8 * 4
constant:
    .word   10

    .text

    .global _start                  @ buena practica, no es obligatorio.

_start:
    ldr     r0, =arr
    ldr     r1, =newArr
    ldr     r2, =length
    ldr     r2, [r2]
    ldr     r3, =constant
    ldr     r3, [r3]

nextIteration:
    ldr     r4, [r0]
    add     r4, r4, r3
    str     r4, [r1]   

    add     r0, r0, #4
    add     r1, r1, #4

    sub     r2, r2, #1
    cmp     r2, #0
    beq     printNewArray

    b       nextIteration 

    ldr     r1, =arr
    mov     r2, #4

printNewArray:
    ldr     r1, =newArr
    ldr     r2, =length
    ldr     r2, [r2]

printNextElement:
    bl      printIntegerInMemoryAdressSavedInR1

    sub     r2, r2, #1
    cmp     r2, #0
    beq     endProgram

    add     r1, r1, #4
    b       printNextElement

printIntegerInMemoryAdressSavedInR1:
    stmfd   sp!, {r1, lr}
    mov     r0, #1
    ldr     r1, [r1]
    swi     0x6b
    ldmfd   sp!, {r1, pc}

endProgram:
    swi     0x11                @ finaliza el prog

    .end