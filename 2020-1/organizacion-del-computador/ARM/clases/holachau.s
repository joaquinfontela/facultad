    .data

mensaje1:
    .asciz      "Hola\n"

mensaje2:
    .asciz      "Chau\n"

    .text

    .global _start                  @ buena practica, no es obligatorio.

_start:
    ldr         r3, =mensaje1       @ muevo al r3 el mensaje1    
    bl          print_r3            @ llamo a la subrutina

    ldr         r3, =mensaje2       @ muevo al r3 el mensaje2
    bl          print_r3            @ llamo a la subrutina

    swi         0x11                @ finaliza el prog


print_r3:

    stmfd sp!, {r0, lr}             
    mov         r0, r3              @ guardo el r3 en el r0
    swi         0x02                @ se imprime por pantalla (es decir, lo que habia en el r3)
    ldmfd sp!, {r0, pc}

    .end