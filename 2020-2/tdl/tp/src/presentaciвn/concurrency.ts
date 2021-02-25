var alarmas: Promise<string>[] = [];
let freq: number = 10;

// Creo las promesas
for (let i: number = 1; i <= freq; i++) {
    alarmas.push(new Promise((resolve, reject) => {
        try {
            setTimeout(() => {
                resolve("Alarma: LEVANTATE VAGO QUE PASARON " + i + " SEGUNDOS");
            }, i * 1000);
        } catch (e) {
            reject(e);
        }
    }));
}

// Dejo que suenen las alarmas
async function execute() {
    alarmas.forEach(async (contador: Promise<string>) => {
        var msgRecieved: any =
            await contador
                .then((successMessage: string) => {
                    return successMessage;
                })
                .catch((e) => {
                    throw e
                });
        console.log(msgRecieved);
    });
}

execute();

