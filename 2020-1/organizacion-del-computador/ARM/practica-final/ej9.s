    .data
fileName:
    .asciz  "ej5.txt"
    .align

inFileHandle:
    .word  0

    .text

    .global _start                  @ buena practica, no es obligatorio.

_start:
    bl      openFile

    bl      readIntegerAndSaveInR1
    mov     r2, r1

    bl      readIntegerAndSaveInR1
    mov     r3, r1

    bl      saveMaxValueBetweenR2AndR3InR1
    bl      printIntegerInR1
    
    b       endProgram

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
    stmfd   sp!, {lr}
    mov     r0, #1
    swi     0x6b
    ldmfd   sp!, {pc}

endProgram:
    swi     0x11                @ finaliza el prog

    .end