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

    public void agregarEnunciadoElegido(String enunciado) {

        this.agregarEnunciado(enunciado, 1, 0);
    }

    public void agregarEnunciadoNoElegido(String enunciado) {

        this.agregarEnunciado(enunciado, 0, 1);
    }

    public void agregarEnunciadoGrupoA(String enunciado) {

        this.agregarEnunciado(enunciado, 0, 1);
    }

    public void agregarEnunciadoGrupoB(String enunciado) {

        this.agregarEnunciado(enunciado, 1, 0);
    }

    private void agregarEnunciado(String enunciado, int identificadorDondeAgregar, int identificadorDondeEliminar) {

        opciones.get(identificadorDondeEliminar).remove(enunciado);
        this.agregarEnunciadoEidentificador(identificadorDondeAgregar,enunciado);
    }

    public void agregarEnunciadoEnOrden(String enunciado) {

        this.agregarEnunciadoEidentificador(orden, enunciado);
        orden = orden + 1;
    }

    public void eliminarEnunciadoEnOrden(String enunciado) {

        int contador = 0;
        while (!opciones.get(contador).contains(enunciado) && contador < opciones.size()) contador++;
        orden = contador;
        for (int i = contador; i < opciones.size(); i++) {
            opciones.remove(i);
        }
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

    @Override
    public String toString() {

        return opciones.toString();
    }
}