package edu.fiuba.algo3.modelo.pregunta.pregunta;

import java.util.ArrayList;
import java.util.HashMap;

public class EnunciadosOpciones {

    private HashMap<Integer, ArrayList<String>> opciones;
    private int orden;

    public EnunciadosOpciones(){

        opciones = new HashMap<>();
        orden = 0;
    }

    public void agregarEnunciadoEidentificador(int identificador, String enunciado) {

        ArrayList<String> enunciadosActuales;
        if (opciones.get(identificador) == null) {
            enunciadosActuales = new ArrayList<>();
        } else {
            enunciadosActuales = opciones.get(identificador);
        }
        enunciadosActuales.add(enunciado);
        opciones.put(identificador, enunciadosActuales);
    }

    public void agregarEnunciadoCorrecto(String enunciado) {
        this.agregarEnunciadoEidentificador(1,enunciado);
    }

    public void agregarEnunciadoIncorrecto(String enunciado) {
        this.agregarEnunciadoEidentificador(0,enunciado);
    }

    public void agregarEnunciadoGrupoA(String enunciado) {
        this.agregarEnunciadoEidentificador(0,enunciado);
    }

    public void agregarEnunciadoGrupoB(String enunciado) {
        this.agregarEnunciadoEidentificador(1,enunciado);
    }

    public void agregarEnunciadoOrdenado(String enunciado) {

        this.agregarEnunciadoEidentificador(orden,enunciado);
        orden = orden + 1;
    }

    public ArrayList<String> enunciadosCorrectos(){
        return opciones.get(1);
    }

    public ArrayList<String> enunciadosIncorrectos(){
        return opciones.get(0);
    }

    public ArrayList<String> enunciadosGrupoA() {
        return opciones.get(0);
    }

    public ArrayList<String> enunciadosGrupoB(){
        return opciones.get(1);
    }

    public ArrayList<String> enunciadosOrdenados() {

        ArrayList<String> enunciadosOrdenados = new ArrayList<>();
        for (int i = 0; i < opciones.size(); i++) {
            enunciadosOrdenados.add(opciones.get(i).get(0));
        }
        return enunciadosOrdenados;
    }
}