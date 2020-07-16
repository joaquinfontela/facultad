global  main
extern  printf
extern  puts
extern  gets
extern  fopen
extern  fgets
extern  fclose

section .data

    mensajeInicial              db          "Ingrese el operando inicial (en caso de ingresar mas de 16 caracteres, solo se tendran en cuenta los 16 primeros): ",0

    input                       db          "0000000000000000",0

    mensajeOperandoInvalido     db          "Operando invalido.",0

    nombreArchivo               db          "registros.txt",0
    modoAperturaArchivo         db          "r",0
    mensajeErr                  db          "Error al abrir el archivo.",0

    formatMensaje               db          "El operando es: %s. La operacion es: %s.",0

    proximoOperandoUno          db          "0000000000000000",0
    operandoUno                 db          "0000000000000000",0
    operandoDos                 db          "0000000000000000",0

    mensajeResultadoParcial     db          "Resultado Parcial = %s",10,0

    valorCero                   db          "0",0
    valorUno                    db          "1",0

    posActualRegistro           dw          0

section .bss

    operacion                   resw        1

    handleArchivo               resq        1

    plusRsp                     resq        1


section .text


main:

pedirOperandoInicial:

    mov     rdi, mensajeInicial
    call    puts

leerOperandoInicial:

    mov     rdi, input
    call    gets

validarOperandoInicial:

    mov     rcx, 16
    mov     qword[posActualRegistro], 0  

validarCaracter:

    push    rcx

compararConCero:

    mov     rbx, qword[posActualRegistro]

    mov     rcx, 1
    lea     rdi, [input + rbx]
    mov     rsi, valorCero
    
    repe    cmpsb
    je      proximoCaracter

compararConUno:

    mov     rbx, qword[posActualRegistro]

    mov     rcx, 1
    lea     rdi, [input + rbx]
    mov     rsi, valorUno
    
    repe    cmpsb
    je      proximoCaracter

imprimirMensajeOperandoInvalido:

    pop     rcx
    mov     rdi, mensajeOperandoInvalido
    call    puts    
    jmp     pedirOperandoInicial


proximoCaracter:

    inc     qword[posActualRegistro]
    pop     rcx
    loop    validarCaracter


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


copiarInputAOperandoUno:                        ; esta es la forma de ignorar los caracteres posteriores a los 16 primeros.

    mov     rcx, 16
    lea     rsi, [input]
    lea     rdi, [operandoUno]
    rep     movsb


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


abrirArchivoDeRegistros:

    mov     rdi, nombreArchivo
    mov     rsi, modoAperturaArchivo
    call    fopen

    cmp     rax, 0
    jle     errAperturaArchivo

    mov     qword[handleArchivo], rax

leerRegistro:

    mov     rdi, operandoDos
    mov     rsi, 17
    mov     rdx, [handleArchivo]
    call    fgets

    cmp     rax, 0
    jle     cerrarArchivoDeRegistros

    mov     rdi, operacion
    mov     rsi, 2
    mov     rdx, [handleArchivo]
    call    fgets

    cmp     rax, 0
    jle     cerrarArchivoDeRegistros

validarOperacion:

    mov     bx, word[operacion]

    cmp     bx, "N"
    je      operarConAnd

    cmp     bx, "O"
    je      operarConOr

    cmp     bx, "X"
    je      operarConXor

    jmp     leerRegistro                     ; cuando la operacion no es valida, se lee el prox registro.


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


operarConAnd:

    mov     qword[posActualRegistro], 0      
    mov     rcx, 16

compararByteOperandoUnoConCero:

    push    rcx
    mov     rbx, qword[posActualRegistro]

    mov     rcx, 1
    lea     rdi, [operandoUno + rbx]
    mov     rsi, valorCero
    
    repe    cmpsb
    je      actualizarValorACeroAnd

compararByteOperandoDosConCero:

    mov     rbx, qword[posActualRegistro]

    mov     rcx, 1
    lea     rdi, [operandoDos + rbx]
    mov     rsi, valorCero
    
    repe    cmpsb
    je      actualizarValorACeroAnd

actualizarValorAUnoAnd:

    mov     rbx, qword[posActualRegistro]
    mov     byte[proximoOperandoUno + rbx], "1"

    jmp     proximoLoopAnd

actualizarValorACeroAnd:

    mov     rbx, qword[posActualRegistro]
    mov     byte[proximoOperandoUno + rbx], "0"

proximoLoopAnd:

    inc     qword[posActualRegistro]
    pop     rcx
    loop    compararByteOperandoUnoConCero 

    jmp     mostrarResultadoParcial


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


operarConOr:

    mov     qword[posActualRegistro], 0      
    mov     rcx, 16

compararByteOperandoUnoConUno:

    push    rcx
    mov     rbx, qword[posActualRegistro]

    mov     rcx, 1
    lea     rdi, [operandoUno + rbx]
    mov     rsi, valorUno
    
    repe    cmpsb
    je      actualizarValorAUnoOr

compararByteOperandoDosConUno:

    mov     rbx, qword[posActualRegistro]

    mov     rcx, 1
    lea     rdi, [operandoDos + rbx]
    mov     rsi, valorUno
    
    repe    cmpsb
    je      actualizarValorAUnoOr

actualizarValorACeroOr:

    mov     rbx, qword[posActualRegistro]
    mov     byte[proximoOperandoUno + rbx], "0"

    jmp     proximoLoopOr

actualizarValorAUnoOr:

    mov     rbx, qword[posActualRegistro]
    mov     byte[proximoOperandoUno + rbx], "1"

proximoLoopOr:

    inc     qword[posActualRegistro]
    pop     rcx
    loop    compararByteOperandoUnoConUno 

    jmp     mostrarResultadoParcial


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


operarConXor:

    mov     qword[posActualRegistro], 0      
    mov     rcx, 16

compararByteAByte:

    push    rcx
    mov     rbx, qword[posActualRegistro]

    mov     rcx, 1
    lea     rdi, [operandoUno + rbx]
    lea     rsi, [operandoDos + rbx]
    
    repe    cmpsb
    je      sonIguales

noSonIguales:

    mov     rbx, qword[posActualRegistro]
    mov     byte[proximoOperandoUno + rbx], "1"

    jmp     proximoLoopXor

sonIguales:

    mov     rbx, qword[posActualRegistro]
    mov     byte[proximoOperandoUno + rbx], "0"

proximoLoopXor:

    inc     qword[posActualRegistro]
    pop     rcx
    loop    compararByteAByte 


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


mostrarResultadoParcial:
    
    mov     rcx, 16
    lea     rsi, [proximoOperandoUno]
    lea     rdi, [operandoUno]
    rep     movsb

    mov     rdi, mensajeResultadoParcial
    mov     rsi, operandoUno
    sub     rax, rax
    call    printf

    jmp     leerRegistro


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


cerrarArchivoDeRegistros:

    mov     rdi, qword[handleArchivo]
    call    fclose

    ret


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


errAperturaArchivo:

    mov     rdi, mensajeErr
    call    puts

    ret


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


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