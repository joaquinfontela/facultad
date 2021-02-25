function letvarLocalidad(): void {

    let existo: number = 1234567890;
    var tambienExisto: string = "Lorem Ipsum!";

    { // Abro un scope nuevo
        console.log(existo);
        console.log(tambienExisto);
    }

}

function varLocalidad(): void {

    { // Abro un scope nuevo
        var noEstamosEnLaB: string = "Running good!";
    }

    console.log(noEstamosEnLaB);
}

// Si descomentamos esto podremos ver que el 
// compilador se queja pues no detecta la variable. 

/*function letLocalidad(): void {

    { // Abro un scope nuevo
        let estamosEnLaB: string = "Nope";
    }

    console.log(estamosEnLaB);

}*/

letvarLocalidad();
varLocalidad();