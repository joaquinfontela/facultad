package edu.fiuba.algo3.modelo.jugador;

public class Jugador {

    private static Integer proximoId = 1;

    private Integer id;
    private String nombre;
    private Integer puntaje;

    public Jugador(String nombre){

        this.id = this.proximoId;
        this.proximoId++;

        this.puntaje = 0;
        this.nombre = nombre;
    }

    public void sumarPuntos(Integer puntos){
        this.puntaje += puntos;
    }

    public Integer obtenerPuntaje(){
        return this.puntaje;
    }
}
