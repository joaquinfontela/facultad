global main
extern printf
extern puts
extern sscanf

section .data
    strNumero1              dw "2F3E",0
    strNumero2              dw "770A",0

    formatoNumeroHexa       db "%x",0
    formatoNumero           db "%hi",0

    msjNumero               db "El numero es %hi.",10,0
    msjNumeroHexa           db "El numero es %x",10,0

section .bss
    numero1hexa             resq   1
    numero2hexa             resq   1

    numero1                 resw   1
    numero2                 resw   1

    RESULT                  resw   1

    plusRsp                 resq   1

section .text

main:

transformarValoresAHexa:

    mov     rdi, strNumero1
    mov     rsi, formatoNumeroHexa
    mov     rdx, numero1hexa

    call    checkAlign
    sub     rsp,[plusRsp]
    call    sscanf
    add     rsp,[plusRsp]

    mov     rdi, strNumero2
    mov     rsi, formatoNumeroHexa
    mov     rdx, numero2hexa

    call    checkAlign
    sub     rsp,[plusRsp]
    call    sscanf
    add     rsp,[plusRsp]

transformarValoresADecimal:

    mov     rdi, msjNumeroHexa
    mov     rsi, qword[numero1hexa]
    sub     rax, rax
    call    printf    

    mov     rdi, numero1hexa
    mov     rsi, formatoNumero
    mov     rdx, numero1

    call    checkAlign
    sub     rsp,[plusRsp]
    call    sscanf
    add     rsp,[plusRsp]

    mov     rdi, msjNumero
    mov     si, word[numero1]
    sub     rax, rax
    call    printf

    mov     rdi, numero2hexa
    mov     rsi, formatoNumero
    mov     rdx, numero2

    call    checkAlign
    sub     rsp,[plusRsp]
    call    sscanf
    add     rsp,[plusRsp]    

    mov     bx, word[numero1]
    add     bx, word[numero2]
    mov     word[RESULT], bx












    























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


