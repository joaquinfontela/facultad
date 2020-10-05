    .data
fileName:
    .asciz  "numero.txt"
    .align

inFileHandle:
    .word   0

    .text

    .global _start                  @ buena practica, no es obligatorio.

_start:

    ldr     r0, =fileName           @ guardo en r0 el nombre del arch
    mov     r1, #0                  @ y en r1 el modo de apertura
    swi     0x66                    @ ejecuto la apertura

    mov     r5, r0                  @ guardo el handler del arch almacenado en r0, en r5.

    swi     0x6c                    @ leo el entero (se guarda en r0)

    mov     r1, r0                  @ el entero leido se guarda en r1 (ya que es el contenido a imprimir)
    mov     r0, #1                  @ en r0 se guarda la modalidad en la que se muestra el numero (1 indica imprimir por pantalla)

    swi     0x6b                    @ se imprime el valor

    mov     r0, r5                  @ muevo el handler del arch a r0
    swi     0x68                    @ cierro el arch

    swi     0x11                    @ finaliza el prog

    .end 