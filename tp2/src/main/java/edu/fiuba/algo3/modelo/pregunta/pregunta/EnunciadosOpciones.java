package edu.fiuba.algo3.modelo.pregunta.pregunta;

import java.util.ArrayList;
import java.util.HashMap;

public class EnunciadosOpciones {

    private HashMap<Integer, ArrayList<String>> opciones;

    public EnunciadosOpciones(){

        opciones = new HashMap<>();
        for (int i = 0; i < 5; i ++) {
            opciones.put(i, new ArrayList<>());
        }
    }

    public void agregarEnunciadoEidentificador(int identificador, String enunciado) {

        opciones.get(identificador).add(enunciado);
    }

    public void agregarEnunciadoElegido(String enunciado) {

        this.agregarEnunciadoEidentificador(1, enunciado);
    }

    public void agregarEnunciadoNoElegido(String enunciado) {

        this.agregarEnunciadoEidentificador(0, enunciado);
    }

    public void agregarEnunciadoGrupoA(String enunciado) {

        this.agregarEnunciadoEidentificador(0, enunciado);
    }

    public void agregarEnunciadoGrupoB(String enunciado) {

        this.agregarEnunciadoEidentificador(1, enunciado);
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
            if (opciones.get(i).size() > 0) {
                enunciadosOrdenados.add(opciones.get(i).get(0));
            }
        }
        return enunciadosOrdenados;
    }

    @Override
    public String toString() {

        return opciones.toString();
    }
}