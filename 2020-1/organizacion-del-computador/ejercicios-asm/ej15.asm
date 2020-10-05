global main
extern printf
extern puts
extern sscanf
extern fopen
extern fgets
extern fclose

section .data
    nombreArchivo                   db      "ej15.txt",0
    modoDeApertura                  db      "r",0
    handleArchivo                   dq      0

    mensajeDeErrorApertura          db      "El archivo no se abrio correctamente.",10,0

    mensajeCantidadDeBytesLeidos    db      "Cantidad bytes leidos: %li", 10,0
    mensajeRegistroLeido            db      "Registro: %s",10,0
    mensajeNumeroTransformado       db      "El numero es: %hi",10,0

    msjOk                           db      "OK",0

    formatoNumero                   db      "%li",0

    suma                            dq      0
    imprimirResultado               db      "El resultado es %li.",10,0

section .bss

    plusRsp                         resq      1

    numero                          resq      1

    registro                        resd      1


section .text


main:

abrirArchivo:

    mov     rdi, nombreArchivo
    mov     rsi, modoDeApertura
    call    fopen

    cmp     rax, 0
    jle     errorDeApertura

    mov     [handleArchivo], rax

leerProximoNumero:

    mov     rdi, registro
    mov     rsi, 4
    mov     rdx, [handleArchivo]
    call    fgets

    cmp     rax, 0
    je      mostrarResultado

transformarRegistroAEntero:

    mov     rdi, registro
    mov     rsi, formatoNumero
    mov     rdx, numero

    call    checkAlign
    sub     rsp, [plusRsp]
    call    sscanf
    add     rsp, [plusRsp]

    cmp     rax, 1
    jl      leerProximoNumero

    mov     rdi, mensajeNumeroTransformado
    mov     rsi, qword[numero]
    sub     rax, rax
    call    printf

actualizarSuma:

    mov     rbx, qword[suma]
    add     rbx, qword[numero]
    mov     qword[suma], rbx

    jmp    leerProximoNumero

    ret

errorDeApertura:

    mov     rdi, mensajeDeErrorApertura
    call    puts
    ret

mostrarResultado:

    mov     rdi, imprimirResultado
    mov     rsi, [suma]
    sub     rax, rax
    call    printf

cerrarArchivo:

    mov     rdi, [handleArchivo]
    call    fclose
    ret









    























;--------------------------------------------------------------------




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


