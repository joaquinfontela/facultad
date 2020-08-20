package edu.fiuba.algo3.modelo.pregunta.respuesta;

import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;

import java.util.ArrayList;

public class RespuestaVerdaderoFalso extends Respuesta {

    private Opcion opcionCorrecta;
    private Opcion opcionIncorrecta;

    public RespuestaVerdaderoFalso() {

        opcionCorrecta = new Opcion(null);
        opcionIncorrecta = new Opcion(null);
    }

    @Override
    public EstadisticasRespuesta compararCon(Respuesta otraRespuesta) {

        EstadisticasRespuesta estadisticas = new EstadisticasRespuesta();

        RespuestaVerdaderoFalso otraRespuestaVerdaderoFalso = (RespuestaVerdaderoFalso) otraRespuesta;

        if (opcionCorrecta.esLaMismaQue(otraRespuestaVerdaderoFalso.opcionCorrecta)) {
            estadisticas.sumarCorrectaElegida();
        } else if (opcionIncorrecta.esLaMismaQue(otraRespuestaVerdaderoFalso.opcionCorrecta)) {
            estadisticas.sumarIncorrectaElegida();
        } else {
            estadisticas.sumarCorrectaNoElegida();
        }

        return estadisticas;
    }

    @Override
    public void rellenar(EnunciadosOpciones opcionesParaAgregar) {

        if (!opcionesParaAgregar.enunciadosCorrectos().isEmpty()) {
            opcionCorrecta = new Opcion(opcionesParaAgregar.enunciadosCorrectos().get(0));
        }
        if (!opcionesParaAgregar.enunciadosIncorrectos().isEmpty()){
            opcionIncorrecta = new Opcion(opcionesParaAgregar.enunciadosIncorrectos().get(0));
        }
    }

    @Override
    public ArrayList<String> obtenerEnunciadosOpciones() {

        ArrayList<String> enunciadosOpciones = new ArrayList<>();
        enunciadosOpciones.add(opcionCorrecta.obtenerEnunciado());
        enunciadosOpciones.add(opcionIncorrecta.obtenerEnunciado());
        return enunciadosOpciones;
    }

    @Override
    public Respuesta crearRespuestaComparable() {
        return new RespuestaVerdaderoFalso();
    }
}