package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion.ExclusividadDePuntaje;
import edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion.Multiplicador;

import java.util.Stack;

public class Jugador {

    private String nombre;
    private int puntaje;
    private Multiplicador multiplicadorX2;
    private Multiplicador multiplicadorX3;
    private Stack<ExclusividadDePuntaje> exclusividades;

    public Jugador(String nombreIngresado) {

        puntaje = 0;
        nombre = nombreIngresado;
        inicializarBonificaciones();
    }

    private void inicializarBonificaciones(){

        multiplicadorX2 = new Multiplicador(2, this);
        multiplicadorX3 = new Multiplicador(3, this);
        exclusividades = new Stack<>();
        for (int i = 0; i < 2; i++) exclusividades.push(new ExclusividadDePuntaje(this));
    }

    public void sumarPuntos(int puntos) {
        puntaje += puntos;
    }

    public int obtenerPuntaje() {
        return puntaje;
    }

    public Multiplicador obtenerMultiplicadorX2() throws Exception {

        if (multiplicadorX2 == null) throw new Exception();
        return multiplicadorX2;
    }

    public void eliminarMultiplicadorX2() {
        multiplicadorX2 = null;
    }

    public Multiplicador obtenerMultiplicadorX3() throws Exception {

        if (multiplicadorX3 == null) throw new Exception();
        return multiplicadorX3;
    }

    public void eliminarMultiplicadorX3() {
        multiplicadorX3 = null;
    }

    public ExclusividadDePuntaje obtenerExclusividad() throws Exception {

        if (exclusividades.empty()) throw new Exception();
        return exclusividades.peek();
    }

    public void eliminarExclusividad() {
        exclusividades.pop();
    }
}