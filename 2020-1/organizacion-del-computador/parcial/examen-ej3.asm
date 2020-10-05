;Se dispone de una matriz de 12x12 que representa un edificio nuevo a estrenar, donde tiene 12 pisos con 12 departamentos en cada uno. 
;Cada elemento de la matriz es un binario de 4 bytes, donde guarda el precio de venta en U$S de cada departamento. 
;Se dispone de un archivo (PRECIOS.DAT) que contiene los precios de los departamentos, donde cada registro del archivo contiene los siguientes campos: 

;Piso: Carácter de 2 bytes 
;Departamento:  Binario de 1 byte  
;Precio venta: Binario de 4 bytes

;Se pide realizar un programa en assembler Intel 80x86 que realice la carga de la matriz a través del archivo. 
;Como la información del archivo puede ser incorrecta se deberá validar haciendo uso de una rutina interna (VALREG) 
;que descartará los registros inválidos (la rutina deberá validar todos los campos del registro).
;Una vez finalizada la carga, se solicitará ingresar por teclado numero (x) y un precio de venta (no se requieren validar) 
;y se deberá mostrar todos los departamentos/pisos cuyo precio de venta sea menor al ingresado.
;Para alumnos con padrón par, x será un numero de piso y se deberá mostrar por pantalla todos los nros de departamento cuyo precio sea inferior al
;ingresado en el piso ingresado.

global 		main
extern      printf
extern      puts
extern      gets
extern      sscanf
extern      fopen
extern      fread
extern      fclose

section .data

    nombreArchivo                           db      "PRECIOS.dat",0
    modoDeApertura                          db      "rb",0
    handleArchivo                           dq      0

    mensajeDeErrorApertura                  db      "El archivo no se abrio correctamente.",10,0

    matrizDeDeptos          times 144       dd      0

    longFila                                db      48
    longColumna                             db      4

	registro			   	times 0			db		""
	piso				   	times 2			db      " "
	depto				   					db		0
	precioVenta				times 4			db		" "

	formatoPiso								db		"%hi",0
	pisoInt									db		0

	formatoPrecioVenta						dw		"%hi",0

	desplazamiento							dw 		0

	msjPedirPiso							db 		"Ingrese un piso (1-12): ",10,0
	msjPedirPrecioVenta						db		"Ingrese un precio maximo de venta: ",10,0

	pisoIngresado							dw		0
	precioVentaIngresado					dw 		0

	pisoIngresadoInt						dw		0
	precioVentaIngresadoInt					dw		0

	msjDepto								db		"El departamento %li tiene un precio menor al ingresado.",10,0

section .bss

    plusRsp                                 resq    1

section .text

main:

abrirArchivo:

    mov     rdi, nombreArchivo
    mov     rsi, modoDeApertura
    call    fopen							; abro el archivo

    cmp     rax, 0
    jle     errorDeApertura				

    mov     [handleArchivo], rax

leerProximoRegistro:

leerPiso:

    mov     rdi, piso
    mov     rsi, 2
    mov     rdx, 1
    mov     rcx, qword[handleArchivo]
    call    fread

    cmp     rax, 0
    je      cerrarArchivo				; no hay mas registros por leer.

leerDepto:

    mov     rdi, depto
    mov     rsi, 1
    mov     rdx, 1
    mov     rcx, qword[handleArchivo]
    call    fread

leerPrecioVenta:

    mov     rdi, precioVenta
    mov     rsi, 4
    mov     rdx, 1
    mov     rcx, qword[handleArchivo]
    call    fread

validacion:

    call    VALREG
	call	actualizarMatrizDeDeptos

    jmp     leerProximoRegistro



VALREG:     

validarPiso:

	mov		di, word[piso]
	mov		rsi, formatoPiso
	mov		rdx, pisoInt

    call	checkAlign
	sub		rsp, [plusRsp]
	call	sscanf
	add		rsp, [plusRsp]

	cmp		rax, 0						; si el piso no se convirtio correctamente, el valor no era valido.
	jle		leerProximoRegistro

	cmp		byte[pisoInt], 1
	jl		leerProximoRegistro			; si el piso es menor a uno, el valor no es valido.

	cmp		byte[pisoInt], 12
	jg		leerProximoRegistro			; si el piso es mayor a doce, el valor no es valido.

validarDepto:

	cmp		byte[depto], 1
	jl		leerProximoRegistro			; si el depto es menor a uno, el valor no es valido.

	cmp		byte[depto], 12
	jg		leerProximoRegistro			; si el depto es mayor a doce, el valor no es valido.

validarPrecioVenta:

	cmp		dword[precioVenta], 0
	jl		leerProximoRegistro			; si el precio es menor a 0, el valor no es valido.

	ret


actualizarMatrizDeDeptos:

    mov     al, byte[pisoInt]
    sub     al, 1
    imul    byte[longFila]                ; 48 es la longitud de una fila (12 columnas x 4 bytes c/u)
    mov     word[desplazamiento], ax

    mov     al, byte[depto]   
    sub     al, 1
    imul    byte[longColumna]                  ; 4 es la longitud de una columna.
    add     word[desplazamiento], ax

    mov     bx, word[desplazamiento]
	mov		eax, dword[precioVenta]
    mov     dword[matrizDeDeptos + ebx], eax		; actualizo el precio del depto en la matriz

	ret


cerrarArchivo:

    mov     rdi, [handleArchivo]
    call    fclose


pedirDatos:

	mov 	rdi, msjPedirPiso
	call	puts

	mov		rdi, pisoIngresado
	call	gets

	mov		rdi, msjPedirPrecioVenta
	call	puts

	mov		rdi, precioVentaIngresado
	call	gets


transformarValoresAEntero:

transformarPisoIngresadoAEntero:

	mov		rdi, pisoIngresado
	mov		rsi, formatoPiso
	mov		rdx, pisoIngresadoInt

    call	checkAlign
	sub		rsp, [plusRsp]
	call	sscanf
	add		rsp, [plusRsp]

transformarPrecioVentaIngresadoAEntero:

	mov		rdi, precioVentaIngresado
	mov		rsi, formatoPiso
	mov		rdx, precioVentaIngresadoInt

    call	checkAlign
	sub		rsp, [plusRsp]
	call	sscanf
	add		rsp, [plusRsp]


posicionarmeEnElPisoCorrespondiente:

	mov		ebx, 48									; largo de cada piso.
	imul	ebx, dword[precioVentaIngresadoInt]		; multiplicado por el piso ingresado, de esta manera me posiciono al principio del piso correspondiente.
	mov		rcx, 12									; cantidad de loops (correspondiente al numero de deptos en el piso).

mostrarDeptosDelPisoIngresadoConPrecioMenorAlIngresado:

	push 	rcx

	mov		eax, dword[matrizDeDeptos + ebx]
	cmp		eax, dword[precioVentaIngresadoInt]			; comparo el valor almacenado en la matriz con el ingresado por el usuario.
	jge		evaluarSiguienteDepto

	pop		rcx

	mov		rdi, msjDepto
	mov		rdx, 13
	sub		rdx, rcx						
	mov 	rsi, rdx								; rcx tiene el numero de loops restantes: si le resto ese valor a 13, me da el depto actual.

	push 	rcx

	sub 	rax, rax
	call	printf

evaluarSiguienteDepto:

	add		ebx, 4									; avanzo a la pos del siguiente depto
	pop		rcx
	loop 	mostrarDeptosDelPisoIngresadoConPrecioMenorAlIngresado

; en algunos lugares apile y desapile el rcx a/de la pila para no perder su valor por algun funcionamiento interno del programa.

errorDeApertura:

    mov     rdi, mensajeDeErrorApertura
    call    puts
    ret												; en caso de error de apertura finaliza el programa.









;--------------------------------------------------------

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