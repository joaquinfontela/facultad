    .data
fileName:
    .asciz  "ej7.txt"
    .align

inFileHandle:
    .word  0

    .text

    .global _start                  @ buena practica, no es obligatorio.

_start:
    mov     r2, #-1

openFile:
    ldr     r0, =fileName
    mov     r1, #0
    swi     0x66
    mov     r9, r0

    bl      readIntegerAndSaveInR1

    cmp     r1, #0
    bmi    invertR1

    bl      printIntegerInR1
    
    b       endProgram

readIntegerAndSaveInR1:
    stmfd   sp!, {lr}
    mov     r0, r9
    swi     0x6c
    mov     r1, r0
    ldmfd   sp!, {pc}

invertR1:
    stmfd   sp!, {lr}
    eor     r1, r1, r2
    add     r1, r1, #1
    ldmfd   sp!, {pc}     

printIntegerInR1:
    stmfd   sp!, {lr}
    mov     r0, #1
    swi     0x6b
    ldmfd   sp!, {pc}

endProgram:
    swi     0x11                @ finaliza el prog

    .end