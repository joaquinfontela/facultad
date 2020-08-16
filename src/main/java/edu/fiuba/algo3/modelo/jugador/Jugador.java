package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion.ExclusividadDePuntaje;
import edu.fiuba.algo3.modelo.pregunta.modalidad.bonificacion.Multiplicador;

import java.util.Stack;

public class Jugador {

    private String nombre;
    private int puntaje;
    private Stack<Multiplicador> multiplicadoresX2;
    private Stack<Multiplicador> multiplicadoresX3;
    private Stack<ExclusividadDePuntaje> exclusividades;

    public Jugador(String nombreIngresado) {

        puntaje = 0;
        nombre = nombreIngresado;
        this.inicializarBonificaciones();
    }

    private void inicializarBonificaciones(){

        multiplicadoresX2 = new Stack<>();
        multiplicadoresX2.add(new Multiplicador(2, this));
        multiplicadoresX3 = new Stack<>();
        multiplicadoresX3.add(new Multiplicador(3, this));
        exclusividades = new Stack<>();
        for (int i = 0; i < 2; i++) exclusividades.push(new ExclusividadDePuntaje(this));
    }

    public String obtenerNombre() {
        return nombre;
    }

    public void sumarPuntos(int puntos) {
        puntaje += puntos;
    }

    public int obtenerPuntaje() {
        return puntaje;
    }

    public Multiplicador obtenerMultiplicadorX2() throws Exception {

        if (multiplicadoresX2.empty()) throw new Exception();
        return multiplicadoresX2.peek();
    }

    public void eliminarMultiplicadorX2() {
        multiplicadoresX2.pop();
    }

    public boolean tieneAlgunMultiplicadorX2() {
        return multiplicadoresX2.isEmpty();
    }

    public Multiplicador obtenerMultiplicadorX3() throws Exception {

        if (multiplicadoresX3.empty()) throw new Exception();
        return multiplicadoresX3.peek();
    }

    public void eliminarMultiplicadorX3() {
        multiplicadoresX3.pop();
    }

    public boolean tieneAlgunMultiplicadorX3() {
        return multiplicadoresX3.isEmpty();
    }

    public ExclusividadDePuntaje obtenerExclusividad() throws Exception {

        if (exclusividades.empty()) throw new Exception();
        return exclusividades.peek();
    }

    public void eliminarExclusividad() {
        exclusividades.pop();
    }

    public boolean tieneAlgunaExclusividad() {
        return exclusividades.isEmpty();
    }
}