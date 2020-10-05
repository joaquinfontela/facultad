global main
extern printf
extern puts

section .data
    matriz     dw 01,02,03,04,05
               dw 06,07,08,09,10
               dw 11,12,13,14,15
               dw 16,17,18,19,20
               dw 21,22,23,24,25

    matriz2    dw 00,00,00,00,05
               dw 00,00,00,09,10
               dw 00,00,13,14,15
               dw 00,17,18,19,20
               dw 21,22,23,24,25

    matriz3    dw 01,02,03,04,05
               dw 06,07,08,09,00
               dw 11,12,13,00,00
               dw 16,17,00,00,00
               dw 21,00,00,00,00

    matriz4    dw 00,00,00,00,05
               dw 00,00,00,09,00
               dw 00,00,13,00,00
               dw 00,17,00,00,00
               dw 21,00,00,00,00


    mensajeTriangularSuperior       db "La matriz es triangular superior.",0
    mensajeTriangularInferior       db "La matriz es triangular inferior.",0
    mensajeNoTriangularSuperior     db "La matriz no es triangular superior.",0
    mensajeNoTriangularInferior     db "La matriz no es triangular inferior.",0


    msjOk                           db "OK.",10,0


section .bss
    desplazamiento              resq 1
    filaActual                  resq 1
    columnaActual               resq 1
    numeroDeColumnasAEvaluar    resq 1


section .text

main:

    mov qword[filaActual], 1
    mov qword[columnaActual], 1

    mov rcx, 4                      
    mov qword[numeroDeColumnasAEvaluar], rcx    ; el rcx guarda el valor de iteraciones sobre la fila actual, es decir, el numero de columnas que deben estar en 0.

verificarSiEsTriangularSuperior:

    push rcx

    mov r8, qword[filaActual]
    sub r8, 1
    imul r8, 10      ; 10 es la longitud de una fila (5 columnas x 2 bytes c/u)
    mov qword[desplazamiento], r8

    mov r8, qword[columnaActual] 
    sub r8, 1
    imul r8, 2       ; 2 es la longitud de una columna.

    add qword[desplazamiento], r8

    mov r8, qword[desplazamiento]
    mov r9w, word[matriz4 + r8]             ; guardo el valor actual de la matriz.

    cmp r9w, 0                              ; comparo el valor con 0
    jne imprimirNoEsTriangularSuperior      ; si el valor no es 0, ya no es triangular superior.

    inc qword[columnaActual]                   
    pop rcx                                 
    loop verificarSiEsTriangularSuperior


avanzarFila:

    inc qword[filaActual]                       ; avanzo de fila
    mov qword[columnaActual], 1                 ; vuelvo a la columna 1

    dec qword[numeroDeColumnasAEvaluar]         ; en la siguiente fila, el numero de columnas a evaular es 1 menos.
    mov rcx, qword[numeroDeColumnasAEvaluar]    ; esa sera la cantidad de iteraciones del loop

    push rcx

    cmp rcx, 0                                  ; si en la proxima fila no hay columnas a evaluar, se termino la verificacion.
    je  esTriangularSuperior                    ; y por lo tanto es triangular superior.

    pop rcx

    jmp verificarSiEsTriangularSuperior


esTriangularSuperior:

    mov rdi, mensajeTriangularSuperior
    call puts

    jmp prepararVerificacionParaTriangularInferior


imprimirNoEsTriangularSuperior:

    mov rdi, mensajeNoTriangularSuperior
    call puts
    jmp prepararVerificacionParaTriangularInferior

prepararVerificacionParaTriangularInferior:

    mov qword[filaActual], 5
    mov qword[columnaActual], 5

    mov rcx, 4                      
    mov qword[numeroDeColumnasAEvaluar], rcx    ; el rcx guarda el valor de iteraciones sobre la fila actual, es decir, el numero de columnas que deben estar en 0.

    jmp verificarSiEsTriangularInferior

verificarSiEsTriangularInferior:

    push rcx

    mov r8, qword[filaActual]
    sub r8, 1
    imul r8, 10      ; 10 es la longitud de una fila (5 columnas x 2 bytes c/u)
    mov qword[desplazamiento], r8

    mov r8, qword[columnaActual] 
    sub r8, 1
    imul r8, 2       ; 2 es la longitud de una columna.

    add qword[desplazamiento], r8

    mov r8, qword[desplazamiento]
    mov r9w, word[matriz4 + r8]             ; guardo el valor actual de la matriz.

    cmp r9w, 0                              ; comparo el valor con 0
    jne noEsTriangularInferior              ; si el valor no es 0, ya no es triangular inferior.

    dec qword[columnaActual]                   
    pop rcx                                 
    loop verificarSiEsTriangularInferior


retrocederFila:

    dec qword[filaActual]                       ; retrocedo de fila
    mov qword[columnaActual], 5                 ; vuelvo a la columna 5

    dec qword[numeroDeColumnasAEvaluar]         ; en la siguiente fila, el numero de columnas a evaular es 1 menos.
    mov rcx, qword[numeroDeColumnasAEvaluar]    ; esa sera la cantidad de iteraciones del loop

    push rcx

    cmp rcx, 0                                  ; si en la proxima fila no hay columnas a evaluar, se termino la verificacion.
    je  esTriangularInferior                    ; y por lo tanto es triangular inferior.

    pop rcx

    jmp verificarSiEsTriangularInferior


esTriangularInferior:

    mov rdi, mensajeTriangularInferior
    call puts
    jmp endProgram

noEsTriangularInferior:

    mov rdi, mensajeNoTriangularInferior
    call puts
    jmp  endProgram

endProgram:

    pop rcx
    pop rcx
    ret






























