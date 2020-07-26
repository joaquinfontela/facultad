package edu.fiuba.algo3.modelo.jugador;

public class Jugador {

    private static Integer proximoId = 1;

    private Integer id;
    private String nombre;
    private Integer puntaje;

    public Jugador(String nombreIngresado) {

        id = proximoId;
        proximoId++;

        puntaje = 0;
        nombre = nombreIngresado;
    }

    public void sumarPuntos(Integer puntos){
        puntaje += puntos;
    }

    public Integer obtenerPuntaje(){
        return puntaje;
    }
}