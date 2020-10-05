global main
extern printf
extern puts
extern sscanf
extern fopen
extern fgets
extern fclose

section .data

    nombreArchivo                           db      "ej17.txt",0
    modoDeApertura                          db      "r",0
    handleArchivo                           dq      0

    mensajeDeErrorApertura                  db      "El archivo no se abrio correctamente.",10,0

    formatoNumero                           db      "%li",0

    puntajeLiderProvisorio                  dq      0

    mensajeCampeon                          db      "El campeon es %s con %li puntos.",10,0


section .bss

    plusRsp                                 resq      1

    nombreEquipo                            resb      21
    resultados                              resb      17

    puntajeEquipoActual                     resq      1

    nombreLiderProvisorio                   resb      21

section .text


main:

abrirArchivo:

    mov     rdi, nombreArchivo
    mov     rsi, modoDeApertura
    call    fopen

    cmp     rax, 0
    jle     errorDeApertura

    mov     [handleArchivo], rax

leerProximoEquipo:

    mov     rdi, nombreEquipo
    mov     rsi, 21
    mov     rdx, [handleArchivo]
    call    fgets

    cmp     rax, 0
    je      imprimirResultados

leerResultados:

    mov     rdi, resultados
    mov     rsi, 18
    mov     rdx, [handleArchivo]
    call    fgets

procesarResultados:

    mov     rcx, 16             ; 16 es la cantidad de partidos de cada equipo.
    mov     rbx, 0              ; partido a evaluar.
    mov     qword[puntajeEquipoActual], 0

procesarResultado:

    push    rcx

    cmp     byte[resultados + rbx], "1"
    jne     procesarProximoResultado

    inc     qword[puntajeEquipoActual]

procesarProximoResultado:

    inc     rbx
    pop     rcx
    loop    procesarResultado

actualizarLider:

    mov     rbx, qword[puntajeLiderProvisorio]
    cmp     qword[puntajeEquipoActual], rbx
    jle     leerProximoEquipo

    mov     rbx, qword[puntajeEquipoActual]
    mov     qword[puntajeLiderProvisorio], rbx

    mov     rbx, qword[nombreEquipo]
    mov     qword[nombreLiderProvisorio], rbx

    jmp     leerProximoEquipo

imprimirResultados:

    mov     rdi, mensajeCampeon
    mov     rsi, nombreLiderProvisorio
    mov     rdx, qword[puntajeLiderProvisorio]
    sub     rax, rax
    call    printf

cerrarArchivo:

    mov     rdi, [handleArchivo]
    call    fclose
    ret

errorDeApertura:

    mov     rdi, mensajeDeErrorApertura
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


