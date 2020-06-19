global main
extern printf
extern sscanf
extern puts

section .data
    vector      times 20    dw 6,7,3,8,15,-9,6,4,8,0,17,21,-14,5,6,1,1,5,9,-3

    mensajeMaximo           db "El maximo del vector es %hi.",10,0
    mensajeMinimo           db "El minimo del vector es %hi.",10,0
    mensajePromedio         db "El promedio del cociente es de %hi (cociente) y %hi (resto).",10,0

    valor                   db "El valor es: %hi",10,0

    tamanioVector           dw 20

section .bss       

    maximo                  resw 1
    minimo                  resw 1

    sumaValores             resw 1



section .text

main: 

    mov ax, word[vector]
    mov word[minimo], ax

    mov word[sumaValores], ax

    mov rcx, 19     ; cantidad de numeros del vector, exceptuando el primero que ya fue evaluado.
    mov rbx, 2      ; pos actual en el vector de numeros.

buscarMinimoYMaximo:

    push rcx

    mov r8w, word[vector + rbx]

    add word[sumaValores], r8w

    cmp r8w, word[minimo]
    jl  actualizarMinimo

    cmp r8w, word[maximo]
    jg  actualizarMaximo

continuar:

    add rbx, 2
    
    pop rcx
    loop buscarMinimoYMaximo

    jmp imprimirDatos


actualizarMinimo:

    mov word[minimo], r8w
    jmp continuar

actualizarMaximo:

    mov word[maximo], r8w
    jmp continuar


imprimirDatos:

    mov rdi, mensajeMinimo
    mov si, [minimo]
    sub rax, rax
    call printf

    mov rdi, mensajeMaximo
    mov si, [maximo]
    sub rax, rax
    call printf

    mov ax, word[sumaValores]
    idiv word[tamanioVector]

    mov rdi, mensajePromedio
    mov si, ax
    sub rax, rax
    call printf

    ret






