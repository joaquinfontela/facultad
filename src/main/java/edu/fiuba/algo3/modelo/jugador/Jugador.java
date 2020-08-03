package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion.ExclusividadDePuntaje;
import edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion.Multiplicador;

import java.util.Stack;

public class Jugador {

    /*private static int proximoId = 1;
    private int id;*/

    private String nombre;
    private int puntaje;
    private Multiplicador multiplicadorX2;
    private Multiplicador multiplicadorX3;
    private Stack<ExclusividadDePuntaje> exclusividades;

    public Jugador(String nombreIngresado) {

        /*id = proximoId;
        proximoId++;*/
        puntaje = 0;
        nombre = nombreIngresado;
        inicializarBonificaciones();
    }

    private void inicializarBonificaciones(){

        multiplicadorX2 = new Multiplicador(2, this);
        multiplicadorX3 = new Multiplicador(3, this);
        exclusividades = new Stack<>();
        for (int i = 0; i < 2; i++) exclusividades.push(new ExclusividadDePuntaje());
    }

    public void sumarPuntos(int puntos) {
        puntaje += puntos;
    }

    public int obtenerPuntaje() {
        return puntaje;
    }

    public Multiplicador obtenerMultiplicadorX2() {

        //if (multiplicadorx2 == null) lanzar excepcion;
        Multiplicador multiplicador = multiplicadorX2;
        multiplicadorX2 = null;
        return multiplicador;
    }

    public Multiplicador obtenerMultiplicadorX3() {

        //if (multiplicadorx3 == null) lanzar excepcion;
        Multiplicador multiplicador = multiplicadorX3;
        multiplicadorX3 = null;
        return multiplicador;
    }

    public ExclusividadDePuntaje obtenerExclusividad() {

        //if (exclusividades.empty()) lanzar excepcion;
        return exclusividades.pop();
    }
}