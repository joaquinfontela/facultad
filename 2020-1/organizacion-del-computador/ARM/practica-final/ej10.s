    .data
fileName:
    .asciz  "ej10.txt"
    .align

inFileHandle:
    .word  0

    .text

    .global _start                  @ buena practica, no es obligatorio.

_start:
    bl      openFile

    bl      readIntegerAndSaveInR1
    mov     r5, r1
    bl      readIntegerAndSaveInR1
    mov     r6, r1
    bl      readIntegerAndSaveInR1
    mov     r7, r1

    mov     r2, r5
    mov     r3, r6
    bl      saveMaxValueBetweenR2AndR3InR1
    mov     r2, r1

    mov     r3, r7
    bl      saveMaxValueBetweenR2AndR3InR1
    cmp     r1, r3
    moveq   r1, r2
    beq     printIntegerInR1

    mov     r2, r5
    bl      saveMaxValueBetweenR2AndR3InR1
    b       printIntegerInR1
    
openFile:
    stmfd   sp!, {lr}
    ldr     r0, =fileName
    mov     r1, #0
    swi     0x66
    mov     r9, r0
    ldmfd   sp!, {pc}

readIntegerAndSaveInR1:
    stmfd   sp!, {lr}
    mov     r0, r9
    swi     0x6c
    mov     r1, r0
    ldmfd   sp!, {pc}

saveMaxValueBetweenR2AndR3InR1:
    stmfd   sp!, {lr}
    cmp     r2, r3
    movmi   r1, r3
    movpl   r1, r2
    ldmfd   sp!, {pc}

printIntegerInR1:
    mov     r0, #1
    swi     0x6b

endProgram:
    swi     0x11                @ finaliza el prog

    .end