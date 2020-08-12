package edu.fiuba.algo3.interfaz.rondasYjugadores;

import edu.fiuba.algo3.interfaz.botones.Boton;
import edu.fiuba.algo3.interfaz.estilos.EstilosBotonEnviarRespuesta;

public class BotonRonda extends Boton {
    public BotonRonda(String cantidadDeRondas){
        super();
        this.setSkin(new EstiloBotonRonda(this,cantidadDeRondas));
    }
}
