global main
extern printf
extern gets
extern sscanf

section .data

    mensajeInicial              db      "El siguiente programa resolvera el calculo X ^ Y.",10,0
    especificaciones            db      "X no puede tener mas de 3 cifras, e Y no puede tener mas de una.",10,0
    mensajePedirX               db      "Ingrese X: ",0
    mensajePedirY               db      "Ingrese Y: ",0
    mensajeResultado            db      "El resultado es: %li.",0
    mensajeResultadoExponenteNegativo    db      "El resultado es: 1 / %li.",0

    mensajeNeg                  db      "Valor negativo.",0

    mensajeYTransformado        db      "y vale %li",0

    numFormat                   db      "%li"

section .bss

    strX                    resq    1
    strY                    resq    1
    x                       resq    1
    y                       resq    1
    resultado               resq    1

    plusRsp                 resq    1

section .text

main:

    mov rdi, mensajeInicial
    sub rax, rax
    call printf

    mov rdi, especificaciones
    sub rax, rax
    call printf

pedirX:

    ; pido x
    mov rdi, mensajePedirX
    sub rax, rax
    call printf   

    ; recibo x
    mov rdi, strX
    call gets

    ; transformo x
    mov rdi, strX
    mov rsi, numFormat
    mov rdx, x
    call checkAlign
    sub rsp,[plusRsp]
    call sscanf
    add rsp,[plusRsp]
    
pedirY:

    mov rdi, mensajePedirY
    sub rax, rax
    call printf   

    mov rdi, strY
    call gets

    mov rdi, strY
    mov rsi, numFormat
    mov rdx, y
    call checkAlign
    sub rsp,[plusRsp]
    call sscanf
    add rsp,[plusRsp]

    mov qword[resultado], 1

    ; verifico si y es positivo o negativo.
    cmp qword[y], 0

    mov rcx, qword[y]

    jg  realizarCalculoExponentePositivo

    jl  realizarCalculoExponenteNegativo

    jmp  imprimirResultado


realizarCalculoExponentePositivo:

    push rcx

    mov r8, qword[resultado]
    imul r8, qword[x]
    mov qword[resultado], r8

    pop rcx
    loop realizarCalculoExponentePositivo

    jmp imprimirResultado


realizarCalculoExponenteNegativo:

    neg rcx

operarConExponenteNegativo:

    push rcx

    mov r8, qword[resultado]
    imul r8, qword[x]
    mov qword[resultado], r8

    pop rcx
    loop operarConExponenteNegativo

    jmp imprimirResultadoExponenteNegativo


imprimirResultadoExponenteNegativo:

    mov rdi, mensajeResultadoExponenteNegativo
    mov rsi, qword[resultado]
    sub rax, rax
    call printf

    ret

imprimirResultado:

    mov rdi, mensajeResultado
    mov rsi, qword[resultado]
    sub rax, rax
    call printf

    ret











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




