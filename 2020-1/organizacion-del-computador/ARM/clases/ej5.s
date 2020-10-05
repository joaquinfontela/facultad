    .data
fileName:
    .asciz  "ej5.txt"
    .align

inFileHandle:
    .word   0

lineBreak:
    .asciz  "\n"

    .text

    .global _start                  @ buena practica, no es obligatorio.

_start:

openFile: 
    ldr     r0, =fileName           @ guardo en r0 el nombre del arch
    mov     r1, #0                  @ y en r1 el modo de apertura
    swi     0x66                    @ ejecuto la apertura

    mov     r5, r0                  @ guardo el handler del arch almacenado en r0, en r5.

readFirstInteger:
    swi     0x6c                    @ leo el entero (se guarda en r0)
    mov     r2, r0                  @ el entero leido se guarda en r2.

readSecondInteger:
    mov     r0, r5

    swi     0x6c
    mov     r3, r0                  @ el entero leido se guarda en r3.

printLines:

printFirstLine:
    mov     r0, #1
    mov     r1, r2
    swi     0x6b

    ldr     r0, =lineBreak
    swi     0x02

printSecondLine:
    mov     r1, #-1
    eor     r2, r2, r1
    mov     r0, #1
    mov     r1, r2
    swi     0x6b

    ldr     r0, =lineBreak
    swi     0x02

printThirdLine:
    mov     r0, #1
    mov     r1, r3
    swi     0x6b

    ldr     r0, =lineBreak
    swi     0x02

printFourthLine:
    mov     r1, #-1
    eor     r3, r3, r1
    mov     r0, #1
    mov     r1, r3
    swi     0x6b

    ldr     r0, =lineBreak
    swi     0x02

closeFile:
    mov     r0, r5                  @ muevo el handler del arch a r0
    swi     0x68                    @ cierro el arch

    swi     0x11                    @ finaliza el prog

    .end