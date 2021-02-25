namespace PERRO {
    export function sonar(): void {
        console.log("El perro dice guau");
    }
}

namespace AVE {
    export function sonar(): void {
        console.log("El pájaro hace pio pio");
    }
}

namespace CHAYANNE {
    export function sonar(): void {
        console.log("¿Y qué más da perder? Si te llevas del todo mi fe ¡Qué no dejaría!");
    }
}

PERRO.sonar();
AVE.sonar();
CHAYANNE.sonar();