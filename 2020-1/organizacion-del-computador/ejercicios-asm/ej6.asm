global main
extern printf
extern gets

section .data
    vector                          dw 3,7,20,1,5,6,-4,-1,0,4,4,4,3,2,3,4,5,8,-9,0,10,-1,2,3,4,6,7,8,9,30

    mensajeMostrarValor             db "El proximo valor es %hi.",10,0

    lineaIntermedia                 db 10,10,10,"___________________________________________",10,10,10,0

section .bss
    vectorInvertido     times 30    resw 1


section .text

main:

    mov rcx, 30     ; cantidad de numeros a mostrar.
    mov rbx, 0      ; pos actual en el vector de numeros.

mostrarValores:

    push rcx
    
    mov rdi, mensajeMostrarValor
    mov rsi, [vector + rbx]
    sub rax, rax
    call printf

    add rbx, 2      ; avanzo en el vector de numeros.

    pop rcx
    loop mostrarValores

;--------------------------------------

    mov rdi, lineaIntermedia
    sub rax, rax
    call printf

    mov rcx, 30
    mov r8, 0       ; pos actual en el vector invertido
    mov r9, 58      ; pos actual en el vector original

rellenarVectorInvertido:

    push rcx

    mov r10w, [vector + r9]
    mov [vectorInvertido + r8], r10w

    add r8, 2
    sub r9, 2

    pop rcx

    loop rellenarVectorInvertido

;--------------------------------------


    mov rcx, 30     ; cantidad de numeros a mostrar.
    mov rbx, 0      ; pos actual en el vector de numeros.


mostrarValoresVectorInvertido:

    push rcx
    
    mov rdi, mensajeMostrarValor
    mov si, [vectorInvertido + rbx]
    sub rax, rax
    call printf

    add rbx, 2      ; avanzo en el vector invertido.

    pop rcx
    loop mostrarValoresVectorInvertido

    ret
