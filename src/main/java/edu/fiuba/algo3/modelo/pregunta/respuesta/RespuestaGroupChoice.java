package edu.fiuba.algo3.modelo.pregunta.respuesta;

import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;

import java.util.ArrayList;
import java.util.HashSet;

public class RespuestaGroupChoice extends Respuesta {

    private HashSet<String> opcionesGrupoA;
    private HashSet<String> opcionesGrupoB;

    public RespuestaGroupChoice() {

        opcionesGrupoA = new HashSet<>();
        opcionesGrupoB = new HashSet<>();
    }

    @Override
    public EstadisticasRespuesta compararCon(Respuesta otraRespuesta) {

        RespuestaGroupChoice otraRespuestaGroupChoice = (RespuestaGroupChoice) otraRespuesta;
        EstadisticasRespuesta estadisticasRespuesta = new EstadisticasRespuesta();

        if (esLaRespuestaCorrecta(otraRespuestaGroupChoice)) {
            estadisticasRespuesta.sumarCorrectaElegida();
        } else {
            estadisticasRespuesta.sumarIncorrectaElegida();
        }

        return estadisticasRespuesta;
    }

    private Boolean esLaRespuestaCorrecta(RespuestaGroupChoice otraRespuesta) {

        return (losGruposAYLosGruposBDeCadaRespuestaSonIguales(otraRespuesta) ||
                 elGrupoADeCadaRespuestaEsIgualAlGrupoBDeLaOtraRespuesta(otraRespuesta));
    }

    private Boolean losGruposAYLosGruposBDeCadaRespuestaSonIguales(RespuestaGroupChoice otraRespuesta) {

        return (opcionesGrupoA.equals(otraRespuesta.opcionesGrupoA) &&
                 opcionesGrupoB.equals(otraRespuesta.opcionesGrupoB));
    }

    private Boolean elGrupoADeCadaRespuestaEsIgualAlGrupoBDeLaOtraRespuesta(RespuestaGroupChoice otraRespuesta) {

        return (opcionesGrupoA.equals(otraRespuesta.opcionesGrupoB) &&
                 opcionesGrupoB.equals(otraRespuesta.opcionesGrupoA));
    }

    @Override
    public void rellenar(EnunciadosOpciones enunciadosOpciones) {

        opcionesGrupoA.addAll(enunciadosOpciones.enunciadosGrupoA());
        opcionesGrupoB.addAll(enunciadosOpciones.enunciadosGrupoB());
    }

    @Override
    public ArrayList<String> obtenerEnunciadosOpciones() {

        ArrayList<String> enunciadosOpciones = new ArrayList<>();
        enunciadosOpciones.addAll(opcionesGrupoA);
        enunciadosOpciones.addAll(opcionesGrupoB);
        return enunciadosOpciones;
    }

    @Override
    public Respuesta crearRespuestaComparable() {
        return new RespuestaGroupChoice();
    }
}