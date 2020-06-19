global main
extern printf
extern puts
extern sscanf

section .data

    RESULT1                         db      "N",0

    str1                            dd      "s2s",0
    str2                            dd      "s2s",0

    lenSTRING_A                     dq      0
    lenSTRING_B                     dq      0

    mensajeCadenasDistintas         db      "Las cadenas son distintas.",10,0
    mensajeCadenasIguales           db      "Las cadenas son iguales.",10,0

    mensajeCantidadAparicionesChar  db      "La cantidad de apariciones de '%c' en '%s' es %i.",10,0
    

section .bss
    STRING_A                        resd    1
    STRING_B                        resd    1

    CHAR                            resb    1

    FULLWORD                        resd    1

    plusRsp                         resq    1


section .text

main:

    mov     eax, dword[str1]
    mov     dword[STRING_A], eax

    mov     ebx, dword[str2]
    mov     dword[STRING_B], ebx

    call    sonIguales
    
    mov     byte[CHAR], "s"
    call    obtenerCantidadDeAparicionesDeChar

    ret

sonIguales:

verificarIgualCantidadDeCaracteres:

    mov     rbx, 0

obtenerCantidadDeCaracteresStrA:

    mov     al, byte[STRING_A + rbx]
    cmp     al, 0

    je      prepararObtenerCantidadDeCaracteresStrB

    inc     qword[lenSTRING_A]
    inc     rbx
    jmp     obtenerCantidadDeCaracteresStrA

prepararObtenerCantidadDeCaracteresStrB:

    mov     rbx, 0

obtenerCantidadDeCaracteresStrB:

    mov     al, byte[STRING_B + rbx]
    cmp     al, 0

    je      compararCantidadDeCaracteres

    inc     qword[lenSTRING_B]
    inc     rbx
    jmp     obtenerCantidadDeCaracteresStrB

compararCantidadDeCaracteres:

    mov     rax, qword[lenSTRING_A]
    sub     rax, qword[lenSTRING_B]

    cmp     rax, 0
    jne     imprimirCadenasDistintas

compararCaracteres:

    mov     rcx, qword[lenSTRING_A]
    mov     rsi, STRING_A
    mov     rdi, STRING_B

    repe    cmpsb

    jne     imprimirCadenasDistintas

imprimirCadenasIguales:

    mov     byte[RESULT1], "S"
    mov     rdi, mensajeCadenasIguales
    call    puts

    ret

imprimirCadenasDistintas:

    mov     byte[RESULT1], "N"
    mov     rdi, mensajeCadenasDistintas
    call    puts

    ret

obtenerCantidadDeAparicionesDeChar:

    mov     rbx, 0
    mov     dword[FULLWORD], 0

compararCaracterActualConChar:

    mov     al, byte[STRING_A + rbx]
    cmp     al, 0
    je      imprimirResultados

    cmp     al, byte[CHAR]
    je      sumarUnaAparicion

prepararProximaIteracion:

    inc     rbx
    jmp     compararCaracterActualConChar

sumarUnaAparicion:

    inc     dword[FULLWORD]
    jmp     prepararProximaIteracion 

imprimirResultados:

    mov     rdi, mensajeCantidadAparicionesChar
    mov     sil, byte[CHAR]
    mov     edx, STRING_A
    mov     ecx, dword[FULLWORD]
    sub     rax, rax
    call    printf

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


