    .data

string1:
    .asciz      "Hola mundo"

    .text


    ldr         r0, =string1
    swi         0x02
    swi         0x11

    .end