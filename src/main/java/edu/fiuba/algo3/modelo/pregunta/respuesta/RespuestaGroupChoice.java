package edu.fiuba.algo3.modelo.pregunta.respuesta;

import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;

import java.util.HashSet;

public class RespuestaGroupChoice implements Respuesta {

    private HashSet<String> opcionesGrupoA;
    private HashSet<String> opcionesGrupoB;

    public RespuestaGroupChoice(){

        opcionesGrupoA = new HashSet<String>();
        opcionesGrupoB = new HashSet<String>();
    }

    @Override
    public EstadisticasRespuesta compararCon(Respuesta otraRespuesta) {

        RespuestaGroupChoice otraRespuestaGroupChoice = (RespuestaGroupChoice) otraRespuesta;
        EstadisticasRespuesta estadisticasRespuesta = new EstadisticasRespuesta();

        if ( esLaRespuestaCorrecta(otraRespuestaGroupChoice) ) {
            estadisticasRespuesta.sumarCorrectaElegida();
        } else {
            estadisticasRespuesta.sumarIncorrectaElegida();
        }

        return estadisticasRespuesta;
    }

    private Boolean esLaRespuestaCorrecta(RespuestaGroupChoice otraRespuesta) {

        return ( losGruposAYLosGruposBDeCadaRespuestaSonIguales(otraRespuesta) ||
                 elGrupoADeCadaRespuestaEsIgualAlGrupoBDeLaOtraRespuesta(otraRespuesta));

    }

    private Boolean losGruposAYLosGruposBDeCadaRespuestaSonIguales(RespuestaGroupChoice otraRespuesta) {

        return ( opcionesGrupoA.equals(otraRespuesta.opcionesGrupoA) &&
                 opcionesGrupoB.equals(otraRespuesta.opcionesGrupoB));
    }

    private Boolean elGrupoADeCadaRespuestaEsIgualAlGrupoBDeLaOtraRespuesta(RespuestaGroupChoice otraRespuesta) {

        return ( opcionesGrupoA.equals(otraRespuesta.opcionesGrupoB) &&
                 opcionesGrupoB.equals(otraRespuesta.opcionesGrupoA));
    }


    @Override
    public void rellenar(EnunciadosOpciones enunciadosOpciones) {

        for (String enunciadoOpcionGrupoA : enunciadosOpciones.opcionesGrupoA()) {
            opcionesGrupoA.add( enunciadoOpcionGrupoA );
        }
        for (String enunciadoOpcionGrupoB : enunciadosOpciones.opcionesGrupoB()) {
            opcionesGrupoB.add( enunciadoOpcionGrupoB );
        }
    }
}