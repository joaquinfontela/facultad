global main
extern printf
extern puts
extern sscanf

section .data
    dia1                    db "LU",0
    dia2                    db "MA",0
    dia3                    db "MI",0
    dia4                    db "JU",0
    dia5                    db "VI",0
    dia6                    db "SA",0
    dia7                    db "DO",0
    dia8                    db "MIE",0
    dia9                    db "M",0
    dia10                   db "  ",0

    diasValidos             db "LUMAMIJUVISADO",0
    cantCaracteres          db 0

    mensajeEsValido         db "El valor es valido.",0
    mensajeNoEsValido       db "El valor no es valido.",0
    RESULT                  db "N",0

    msjOk                   db "OK. %s",0


section .bss
    DIA                     resb 3

    digito                  resb 1

    letra                   resq 1

    plusRsp                 resq 1

    loopsRestantes          resq 1


section .text

main:

validarCantidadDeCaracteres:

    cmp     byte[dia9 + 2], 0       ; la cadena no puede tener mas de dos caracteres.
    jne     end

    mov     rcx, 7
    mov     rbx, 0      ; posicion en el vector de dias.


validarCaracteres:

    mov     qword[loopsRestantes], rcx

    mov     rcx, 2
    mov     rsi, dia9
    lea     rdi, [diasValidos + rbx]

    repe    cmpsb

    je      diaValido

    add     rbx, 2
    mov     rcx, qword[loopsRestantes]
    loop    validarCaracteres

    jmp     end


diaValido:

    mov     byte[RESULT], "S"

end:

    cmp     byte[RESULT], "S"
    je      esValido

    mov     rdi, mensajeNoEsValido
    call    puts

    ret

esValido:

    mov     rdi, mensajeEsValido
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


