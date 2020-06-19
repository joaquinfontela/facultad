global main
extern printf
extern gets
extern sscanf
extern puts

section .data
    msjPedirNumero          db      "Ingrese un numero: ", 0
    mostrarNumero           db      "El valor es %li.", 10, 0

    formatoNumero           db      "%li",0

    msjOk                   db      "Todo OK!", 0

section .bss
    vectorDeNumeros     times 5    resq 1
    vectorOrdenado      times 5    resq 1

    plusRsp                     resq    1

    strNumero                   resq    1
    numero                      resq    1

    maximoValorDelVector        resq    1
    posicionMaximoValor         resq    1

    posActualVectorOrdenado     resq    1


section .text

main:

    mov rcx, 5      ; cantidad de numeros a pedir.
    mov rbx, 0      ; pos actual en el vector de numeros.

pedirNumero:

    push rcx
    
    mov rdi, msjPedirNumero
    sub rax, rax
    call printf

    mov rdi, strNumero
    call gets

convertirNumero:

    mov rdi, strNumero
    mov rsi, formatoNumero
    mov rdx, numero

    call checkAlign
    sub rsp, [plusRsp]
    call sscanf
    add rsp, [plusRsp]

agregarNumeroAlVector:

    mov r8, qword[numero]
    mov qword[vectorDeNumeros+rbx], r8

    add rbx, 8      ; avanzo en el vector de numeros.

    pop rcx
    loop pedirNumero

;----------------------------------------------------------

    mov rcx, 5
    mov rbx, 0      ; pos actual en el vector de numeros.
    mov qword[posActualVectorOrdenado], rbx


ponerAlValorMasGrandeAlPrincipio:

    push rcx

    mov r8, qword[vectorDeNumeros + rbx]
    mov qword[maximoValorDelVector], r8

    pop rcx

buscarMayorElemento:

    push rcx

    add rbx, 8

    mov r8, qword[vectorDeNumeros + rbx]    ; obtengo el valor actual de la iteracion.

    cmp r8, qword[maximoValorDelVector]
    jg actualizarMaximoValor

continuarProximoElemento:

    pop rcx
    loop buscarMayorElemento

switchMayorElementoYPrimerElemento:

    push rcx             

    ; muevo el mayor valor a la posicion donde le corresponde (la primera no ordenada).
    mov r9, qword[posicionMaximoValor]
    mov r10, qword[vectorDeNumeros + r9]
    mov qword[vectorOrdenado + rbx], r10

    mov rbx, qword[posActualVectorOrdenado]
    add rbx, 8
    pop rcx
    loop ponerAlValorMasGrandeAlPrincipio

    mov rcx, 5
    mov rbx, 0


mostrarValores:

    push rcx

    mov rdi, mostrarNumero
    mov rsi, [vectorOrdenado + rbx]
    sub rax, rax
    call printf

    add rbx, 8
    
    pop rcx
    loop mostrarValores

    ret

actualizarMaximoValor:

    mov qword[maximoValorDelVector], r8

    jmp continuarProximoElemento































;----------------------------------------------------------------------------------

checkAlign:
	push rax
	push rbx
;	push rcx
	push rdx
	push rdi

	mov   qword[plusRsp],0
	mov		rdx,0

	mov		rax,rsp		
	add   rax,8		;para sumar lo q restó la CALL 
	add		rax,32	;para sumar lo que restaron las PUSH
	
	mov		rbx,16
	idiv	rbx			;rdx:rax / 16   resto queda en RDX

	cmp  rdx,0		;Resto = 0?
	je		finCheckAlign
;mov rdi,msj
;call puts
	mov   qword[plusRsp],8
finCheckAlign:
	pop rdi
	pop rdx
;	pop rcx
	pop rbx
	pop rax
	ret




