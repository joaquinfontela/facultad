    .data

    .text

    .global _start                  @ buena practica, no es obligatorio.

_start:
    mov         r0, #4              @ muevo al r0 el valor numerico 4.   
    mov         r1, #3              @ muevo al r1 el valor numerico 3.

    bl          suma                
    bl          resta
    bl          multiplicacion
    bl          opAnd
    bl          opOr
    bl          opXor
    bl          shiftLogicoIzq
    bl          shiftLogicoDer
    bl          shiftAritmeticoDer

    swi         0x11                @ finaliza el prog


suma:
    add         r2, r0, r1          @ r2 = r0 + r1
    mov         pc, lr

resta:
    sub         r3, r0, r1          @ r3 = r0 - r1
    mov         pc, lr

multiplicacion:
    mul         r4, r0, r1          @ r4 = r0 * r1
    mov         pc, lr

opAnd:
    and         r5, r0, r1          @ r5 = r0 AND r1
    mov         pc, lr

opOr:
    orr         r6, r0, r1          @ r6 = r0 OR r1
    mov         pc, lr

opXor:
    eor         r7, r0, r1          @ r7 = r0 XOR r1
    mov         pc, lr

shiftLogicoIzq:
    mov         r8, r0, lsl #1      @ guardo en r8 un shifteado de un bit de r0.
    mov         pc, lr

shiftLogicoDer:
    mov         r9, r0, lsr #1      @ guardo en r9 un shifteado de un bit de r0.
    mov         pc, lr

shiftAritmeticoDer:
    mov         r10, r0, asr #1     @ guardo en r10 un shifteado aritmetico de r0.
    mov         pc, lr

    .end