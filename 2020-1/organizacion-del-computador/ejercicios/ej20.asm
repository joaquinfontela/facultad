; Se dispone de una matriz C que representa un calendario de actividades de una persona. 
; La matriz C está formada por 7 columnas (que corresponden a los días de la semana) 
; y por 6 filas (que corresponden a las semanas que puede tener como máximo un mes en un calendario).
; Cada elemento de la matriz es un BPF S/Signo de 2 bytes (word) 
; representa la cantidad de actividades que realizará dicho día en la semana.
; Además se dispone de un archivo de entrada llamado CALEN.DAT donde cada registro tiene el siguiente formato:
; - Día de la semana: Carácter de 2 bytes (DO, LU, MA, MI, JU, VI, SA)
; - Semana: Binario de 1 byte (1..6)
; - Actividad: Caracteres de longitud 20 con la descripción.
; Como la información leída del archivo puede ser errónea, 
; se dispone de una rutina interna llamada VALCAL para su validación.
; Se pide realizar un programa assembler Intel x86 que actualice la matriz C con aquellos registros válidos. 
; Al finalizar la actualización se solicitará el ingreso por teclado de una semana 
; y se debe generar un listado indicando “Dia de la Semana – Cantidad de Actividades”.

global      main
extern      printf
extern      puts
extern      gets
extern      sscanf
extern      fopen
extern      fread
extern      fclose

section .data

    nombreArchivo                           db      "CALEN.dat",0
    modoDeApertura                          db      "rb",0
    handleArchivo                           dq      0

    mensajeDeErrorApertura                  db      "El archivo no se abrio correctamente.",10,0

    matrizC             times 42            dw      0

    diasValidos                             db      "DOLUMAMIJUVISA",0

    registroValido                          db      "N",0

    diaBinario                              dq      0

    msjOk                                   db      "OK.",0

    longFila                                db      14
    longColumna                             db      2

    calendario                              db      "Domingo     ",0
                                            db      "Lunes       ",0
                                            db      "Martes      ",0
                                            db      "Miercoles   ",0
                                            db      "Jueves      ",0
                                            db      "Viernes     ",0
                                            db      "Sabado      ",0

    mensajePedirSemana                      db      "Ingrese una semana (1-6): ",0
    formatoSemana                           db      "%i",0

    mostrarSemana                           db      "La semana es %hi",0
                                            

section .bss

    registro            times 0             resb    23
    dia                 times 2             resb    1
    semana              times 1             resb    1
    actividad           times 20            resb    1

    plusRsp                                 resq    1

    desplazamiento                          resb    1

    semanaStr                               resb    1
    semanaInt                               resd    1

section .text

main:

abrirArchivo:

    mov     rdi, nombreArchivo
    mov     rsi, modoDeApertura
    call    fopen

    cmp     rax, 0
    jle     errorDeApertura

    mov     [handleArchivo], rax

leerProximoRegistro:

leerDia:

    mov     rdi, dia
    mov     rsi, 2
    mov     rdx, 1
    mov     rcx, qword[handleArchivo]
    call    fread

    cmp     rax, 0
    je      pedirSemana

leerSemana:

    mov     rdi, semana
    mov     rsi, 1
    mov     rdx, 1
    mov     rcx, qword[handleArchivo]
    call    fread

leerActividad:

    mov     rdi, actividad
    mov     rsi, 20
    mov     rdx, 1
    mov     rcx, qword[handleArchivo]
    call    fread

validacion:

    call    VALCAL

    jmp     leerProximoRegistro



VALCAL:

    mov     rcx, 7          ; para el loop, la cantidad de dias que tiene la semana.
    mov     rbx, 0          ; pos en el vector de dias validos.
    mov     rax, 0          ; dia de la semana binario

validarDia:

    inc     rax
    push    rcx

    mov     rcx, 2
    mov     rsi, dia
    lea     rdi, [diasValidos + rbx]

    repe    cmpsb
    pop     rcx

    je      validarSemana

    add     rbx,2
    loop    validarDia

    jmp     registroInvalido

validarSemana:

    mov     byte[diaBinario], al

    cmp     byte[semana], 1
    jl      registroInvalido

    cmp     byte[semana], 6
    jg      registroInvalido

actualizarMatriz:

    mov     al, byte[semana]
    sub     al, 1
    imul    byte[longFila]                ; 14 es la longitud de una fila (7 columnas x 2 bytes c/u)
    mov     byte[desplazamiento], al

    mov     al, byte[diaBinario]   
    sub     al, 1
    imul    byte[longColumna]                  ; 2 es la longitud de una columna.
    add     byte[desplazamiento], al

    mov     bl, byte[desplazamiento]
    inc     word[matrizC + ebx]

    jmp     leerProximoRegistro

pedirSemana:

    mov     rdi, mensajePedirSemana
    call    puts

    mov     rdi, semanaStr
    call    gets

validarSemanaIngresada:

    mov     rdi, semanaStr
    mov     rsi, formatoSemana
    mov     edx, semanaInt

    call    checkAlign
    sub     rsp, [plusRsp]
    call    sscanf
    add     rsp, [plusRsp]

    cmp     rax, 0
    jle     pedirSemana

    cmp     dword[semanaInt], 1
    jl      pedirSemana

    cmp     dword[semanaInt], 6
    jg      pedirSemana

cerrarArchivo:

    mov     rdi, [handleArchivo]
    call    fclose

    ret

registroInvalido:

    mov     byte[registroValido], "N"
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
