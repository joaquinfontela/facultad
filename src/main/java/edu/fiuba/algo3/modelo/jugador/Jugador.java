package edu.fiuba.algo3.modelo.jugador;

public class Jugador {

    private static Integer proximoId = 1;

    private int id;
    private String nombre;
    private int puntaje;

    public Jugador(String nombreIngresado) {

        id = proximoId;
        proximoId++;

        puntaje = 0;
        nombre = nombreIngresado;
    }

    public void sumarPuntos(int puntos){
        puntaje += puntos;
    }

    public int obtenerPuntaje(){
        return puntaje;
    }

    public boolean esElMismo(int idParaConfirmar) {
        return (id == idParaConfirmar);
    }

    public int obtenerId() {
        return id;
    }
}