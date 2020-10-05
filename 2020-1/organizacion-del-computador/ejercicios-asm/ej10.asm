global main
extern printf
extern puts
extern sscanf

section .data
    PACK1                   db "1074A",0
    PACK2                   db "1F03E",0
    PACK3                   db "14902",0
    PACK4                   db "1209G",0
    PACK5                   db "2945F",0

    letrasValidas           dw "ABCDEF",0

    formatoNumero           dw "%hi",0


    mensajeEsValido         db "El valor es valido.",0
    mensajeNoEsValido       db "El valor no es valido.",0

    mensajeDigitoStr        db "El digito es %s",10,0




section .bss
    RESULT                  resb 1

    digito                  resb 1

    letra                   resq 1

    plusRsp                 resq 1


section .text

main:


    mov     rcx, 0

validarParteNumerica:

    mov rdi, [PACK1]
    call puts

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

