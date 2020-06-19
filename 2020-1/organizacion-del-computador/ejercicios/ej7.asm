global main
extern printf

section .data
    matriz      times 9     dw 4,7,3,6,-2,0,4,0,7

    cantidadDeFilas         dq 3

    traza                   dw 0

    mensajeResultado        db "El resultado es %hi.",0

    mensajeValorActual      db "El valor actual es %hi",10,0

section .bss
    desplazamiento          resq 1
    filaActual              resq 1


section .text

main:

    mov rcx, 3      ; cantidad de filas y columnas de la matriz.
    mov qword[filaActual], 1

calcularTraza:

    push rcx

    mov r8, qword[filaActual]
    sub r8, 1
    imul r8, 6      ; 6 es la longitud de una fila (3 columnas x 2 bytes c/u)
    mov qword[desplazamiento], r8

    mov r8, qword[filaActual]   ; la fila actual tambien es al numero de columna al cual queremos ir.
    sub r8, 1
    imul r8, 2      ; 2 es la longitud de una columna.

    add qword[desplazamiento], r8

    mov r8, qword[desplazamiento]
    mov r9w, [matriz + r8]
    add [traza], r9w

    add qword[filaActual], 1

    pop rcx
    loop calcularTraza


mostrarResultado:

    mov rdi, mensajeResultado
    mov si, word[traza]
    sub rax, rax
    call printf

    ret
































