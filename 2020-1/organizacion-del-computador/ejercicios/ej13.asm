global main
extern printf
extern puts
extern sscanf

section .data
    fecha                   db "05/12/2345",0

    mensajeEsValido         db "El valor es valido.",0
    mensajeNoEsValido       db "El valor no es valido.",0
    RESULT                  db "N",0

    msjNumeroStr            db "NumeroStr: %s",10,0
    msjNumero               db "Numero: %li",10,0

    formatoNumero           db "%li",0


section .bss
    strDia                  resb 3
    dia                     resq 1

    strMes                  resb 3
    mes                     resq 1

    strAnio                 resb 5
    anio                    resq 1

    plusRsp                 resq 1


section .text

main:

validarFormatoDeLaFecha:

    cmp     byte[fecha + 2], "/"      
    jne     fechaNoValida

    cmp     byte[fecha + 5], "/"      
    jne     fechaNoValida

    cmp     byte[fecha + 10], 0      
    jne     fechaNoValida


obtenerStrDia:

    mov     al, byte[fecha + 0]
    mov     byte[strDia + 0], al  
    mov     al, byte[fecha + 1]
    mov     byte[strDia + 1], al  

transformarDiaAEntero:

    mov     rdi, strDia
    mov     rsi, formatoNumero
    mov     rdx, dia

    call    checkAlign
    sub     rsp,[plusRsp]
    call    sscanf
    add     rsp,[plusRsp]

validarDia:

    cmp     rax, 1              ; en el rax queda el numero de valores convertido correctamente.
    jl      fechaNoValida

    mov     rdi, msjNumero
    mov     rsi, qword[dia]
    sub     rax, rax
    call    printf

    cmp     qword[dia], 1       ; el dia debe ser mayor o igual a 1.
    jl      fechaNoValida

    cmp     qword[dia], 31      ; el dia debe ser menos o igual a 31.
    jg      fechaNoValida


obtenerStrMes:

    mov     al, byte[fecha + 3]
    mov     byte[strMes + 0], al  
    mov     al, byte[fecha + 4]
    mov     byte[strMes + 1], al  

transformarMesAEntero:

    mov     rdi, strMes
    mov     rsi, formatoNumero
    mov     rdx, mes

    call    checkAlign
    sub     rsp,[plusRsp]
    call    sscanf
    add     rsp,[plusRsp]

validarMes:

    cmp     rax, 1              ; en el rax queda el numero de valores convertido correctamente.
    jl      fechaNoValida

    mov     rdi, msjNumero
    mov     rsi, qword[mes]
    sub     rax, rax
    call    printf

    cmp     qword[mes], 1       ; el mes debe ser mayor o igual a 1.
    jl      fechaNoValida

    cmp     qword[mes], 12      ; el mes debe ser menos o igual a 12.
    jg      fechaNoValida


obtenerStrAnio:

    mov     al, byte[fecha + 6]
    mov     byte[strAnio + 0], al  
    mov     al, byte[fecha + 7]
    mov     byte[strAnio + 1], al  
    mov     al, byte[fecha + 8]
    mov     byte[strAnio + 2], al
    mov     al, byte[fecha + 9]
    mov     byte[strAnio + 3], al

transformarAnioAEntero:

    mov     rdi, strAnio
    mov     rsi, formatoNumero
    mov     rdx, anio

    call    checkAlign
    sub     rsp,[plusRsp]
    call    sscanf
    add     rsp,[plusRsp]

validarAnio:

    cmp     rax, 1              ; en el rax queda el numero de valores convertido correctamente.
    jl      fechaNoValida

    mov     rdi, msjNumero
    mov     rsi, qword[anio]
    sub     rax, rax
    call    printf

    cmp     qword[anio], 0       ; el anio debe ser mayor o igual a 0.
    jl      fechaNoValida

    cmp     qword[anio], 9999      ; el anio debe ser menos o igual a 9999.
    jg      fechaNoValida


fechaValida:

    mov     byte[RESULT], "S"

    mov     rdi, mensajeEsValido
    call    puts

    ret

fechaNoValida:

    mov     rdi, mensajeNoEsValido
    call    puts

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


