global main
extern printf

section .data
    matriz     dw 01,02,03,04
               dw 05,06,07,08
               dw 09,10,11,12
               dw 13,14,15,16

    cantidadDeFilas         dq 4

    diagonalInversa         dw 0

    mensajeResultado        db "El resultado es %hi.",0

section .bss
    desplazamiento          resq 1
    filaActual              resq 1
    columnaActual           resq 1


section .text

main:

    mov rcx, 4                   ; cantidad de filas y columnas de la matriz.
    mov qword[filaActual], 1
    mov qword[columnaActual], 4

calcularDiagonalInversa:

    push rcx

    mov r8, qword[filaActual]
    sub r8, 1
    imul r8, 8      ; 8 es la longitud de una fila (4 columnas x 2 bytes c/u)
    mov qword[desplazamiento], r8

    mov r8, qword[columnaActual] 
    sub r8, 1
    imul r8, 2      ; 2 es la longitud de una columna.

    add qword[desplazamiento], r8

    mov r8, qword[desplazamiento]
    mov r9w, [matriz + r8]
    add [diagonalInversa], r9w

    inc qword[filaActual]
    dec qword[columnaActual]

    pop rcx
    loop calcularDiagonalInversa


mostrarResultado:

    mov rdi, mensajeResultado
    mov si, word[diagonalInversa]
    sub rax, rax
    call printf

    ret
































