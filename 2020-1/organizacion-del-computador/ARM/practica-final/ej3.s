    .data
numero1:
    .word 5

numero2:
    .word 3

    .text

    .global _start                  @ buena practica, no es obligatorio.

_start:
    ldr     r0, =numero1
    ldr     r0, [r0]
    ldr     r1, =numero2
    ldr     r1, [r1]

    bl      suma
    bl      resta
    bl      mult
    bl      opAnd
    bl      opOr
    bl      opXor
    bl      shiftIzq
    bl      shiftDer
    bl      shiftDerAr
    b       finalizarPrograma

suma:
    stmfd   sp!, {lr}
    add     r2, r0, r1      
    ldmfd   sp!, {pc}

resta:
    stmfd   sp!, {lr}
    sub     r3, r0, r1
    ldmfd   sp!, {pc}
    
mult:
    stmfd   sp!, {lr}
    mul     r4, r0, r1
    ldmfd   sp!, {pc}
    
opAnd:
    stmfd   sp!, {lr}
    and     r5, r0, r1
    ldmfd   sp!, {pc}
    
opOr:
    stmfd   sp!, {lr}
    orr     r6, r0, r1
    ldmfd   sp!, {pc}
    
opXor:
    stmfd   sp!, {lr}
    eor     r7, r0, r1
    ldmfd   sp!, {pc}
    
shiftIzq:
    stmfd   sp!, {lr}
    mov     r8, r0, LSL #1
    ldmfd   sp!, {pc}
    
shiftDer:
    stmfd   sp!, {lr}
    mov     r9, r0, LSR #1
    ldmfd   sp!, {pc}
    
shiftDerAr:
    stmfd   sp!, {lr}
    mov     r10, r0, ASR #1
    ldmfd   sp!, {pc}

finalizarPrograma:
    swi     0x11                @ finaliza el prog

    .end