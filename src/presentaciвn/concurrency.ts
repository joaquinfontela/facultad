var alarmas: Promise<any>[] = [];
let freq: number = 10;

// Creo las promesas
for (let i: number = 1; i <= freq; i++) {
    alarmas.push(new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve("Alarma: LEVANTATE VAGO QUE PASARON " + i + " SEGUNDOS");
        }, i * 1000);
    }));
}

// Dejo que suenen las alarmas
alarmas.forEach((contador: Promise<any>) => {
    contador.then((successMessage: string) => {
        console.log(successMessage);
    });
});
