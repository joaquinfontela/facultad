package edu.fiuba.algo3.modelo.pregunta.pregunta;

import java.util.ArrayList;
import java.util.HashMap;
import edu.fiuba.algo3.modelo.pregunta.modalidad.Modalidad;
import edu.fiuba.algo3.modelo.pregunta.respuesta.OpcionElegible;
import edu.fiuba.algo3.modelo.pregunta.respuesta.Respuesta;
import edu.fiuba.algo3.modelo.pregunta.respuesta.RespuestaVerdaderoFalso;

public class VerdaderoFalso extends PreguntaDeSeleccion {

    public VerdaderoFalso(Modalidad modalidad, String enunciado, ArrayList<String> enunciadosCorrectos,
                   ArrayList<String> enunciadosIncorrectos){
        super(modalidad, enunciado, enunciadosCorrectos, enunciadosIncorrectos);
        this.respuestaCorrecta = new RespuestaVerdaderoFalso();
        this.inicializarOpcionesRespuestaCorrecta();
    }

    protected void inicializarOpcionesRespuestaCorrecta(){
        OpcionElegible opcionCorrecta = new OpcionElegible(1, enunciadosCorrectos.get(0));
        opcionCorrecta.elegir();
        this.respuestaCorrecta.agregarOpcion(opcionCorrecta);

        OpcionElegible opcionIncorrecta = new OpcionElegible(2, enunciadosIncorrectos.get(0));
        this.respuestaCorrecta.agregarOpcion(opcionIncorrecta);
    }

    @Override
    public HashMap<Integer, Integer> obtenerPuntajePorJugador(HashMap<Integer, Respuesta> idsJugadores_respuestas){
        return new HashMap<Integer, Integer>();
    }
}
