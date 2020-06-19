global main
extern printf
extern gets
extern sscanf

section .data
    mensaje                     db      "El alumno %s %s de Padrón N° %s tiene %hi años",0
    pedirNombre                 db      "Ingrese su nombre: ",0
    pedirApellido               db      "Ingrese su apellido: ",0
    pedirPadron                 db      "Ingrese su padron: ",0
    pedirFechaDeNacimiento      db      "Ingrese su fecha de nacimiento: ",0

    anioActual                  dw      2020
    anoDeNacimientoFormat       db      "%hi",0

section .bss
    nombre                  resb    20
    apellido                resb    30
    padron                  resb    7
    fechaDeNacimiento       resb    10

    plusRsp                 resq    1

    anioDeNacimientoStr     resb    4
    anioDeNacimiento        resw    1    

    edad                    resw    1


section .text

main:

    mov rdi, pedirNombre
    sub rax, rax
    call printf

    mov rdi, nombre
    call gets

    mov rdi, pedirApellido
    sub rax, rax
    call printf

    mov rdi, apellido
    call gets

    mov rdi, pedirPadron
    sub rax, rax
    call printf

    mov rdi, padron
    call gets

    mov rdi, pedirFechaDeNacimiento
    sub rax, rax
    call printf

    mov rdi, fechaDeNacimiento
    call gets

    mov rcx, 4
    mov rbx, 6
    mov rdx, 0


obtenerAnioDeNacimiento:

    push rcx

    mov al, byte[fechaDeNacimiento + rbx]
    mov byte[anioDeNacimientoStr + rdx], al

    inc rdx
    inc rbx
    pop rcx
    loop obtenerAnioDeNacimiento

    mov rdi, anioDeNacimientoStr
    mov rsi, anoDeNacimientoFormat
    mov rdx, anioDeNacimiento
    call checkAlign
    sub rsp, [plusRsp]
    call sscanf
    add rsp, [plusRsp]

    mov r8w, word[anioActual]
    sub r8w, word[anioDeNacimiento]
    mov word[edad], r8w

    mov rdi, mensaje
    mov rsi, nombre
    mov rdx, apellido
    mov rcx, padron
    mov r8, [edad]
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
