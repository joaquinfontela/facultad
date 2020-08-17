package edu.fiuba.algo3.modelo;

import com.google.gson.*;
import edu.fiuba.algo3.modelo.pregunta.pregunta.EnunciadosOpciones;
import edu.fiuba.algo3.modelo.pregunta.pregunta.InformacionPregunta;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class LectorDeArchivo {

    private Gson gson;
    private JsonParser parser;
    private FileReader lector;
    private JsonArray preguntasEnFormatoJson;
    private ArrayList<InformacionPregunta> informacionPreguntas;

    public LectorDeArchivo() {

        gson = new Gson();
        parser = new JsonParser();

        try {
            lector = new FileReader("src/main/java/edu/fiuba/algo3/archivos/preguntas.json");
            obtenerDatosArchivoEnFormatoJson();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo fuente.");
        }
    }

    private void obtenerDatosArchivoEnFormatoJson() {

        JsonElement datos = parser.parse(lector);
        JsonObject datosArchivoJson = datos.getAsJsonObject();
        preguntasEnFormatoJson = datosArchivoJson.getAsJsonArray("preguntas");
    }

    public ArrayList<InformacionPregunta> obtenerListaDeInformacionDePreguntas() {

        informacionPreguntas = new ArrayList<>();
        for (JsonElement preguntaEnFormatoJson : preguntasEnFormatoJson){

            agregarInformacionDePreguntaALaLista(preguntaEnFormatoJson);
        }

        return informacionPreguntas;
    }

    private void agregarInformacionDePreguntaALaLista(JsonElement preguntaEnFormatoJson) {

        EnunciadosOpciones enunciadosOpciones = obtenerEnunciadosOpcionesDeLaPregunta(preguntaEnFormatoJson);
        int modalidadId = preguntaEnFormatoJson.getAsJsonObject().get("modalidad id").getAsInt();
        int tipoPreguntaId = preguntaEnFormatoJson.getAsJsonObject().get("tipo pregunta id").getAsInt();
        String enunciadoPregunta = preguntaEnFormatoJson.getAsJsonObject().get("enunciado").getAsString();

        informacionPreguntas.add(new InformacionPregunta(modalidadId, tipoPreguntaId,
                                                            enunciadoPregunta, enunciadosOpciones));
    }

    private EnunciadosOpciones obtenerEnunciadosOpcionesDeLaPregunta(JsonElement preguntaEnFormatoJson) {

        EnunciadosOpciones enunciadosOpciones = new EnunciadosOpciones();

        JsonObject opciones = preguntaEnFormatoJson.getAsJsonObject().getAsJsonObject("opciones");
        for (String identificador : opciones.keySet()){
            for (JsonElement opcion : opciones.get(identificador).getAsJsonArray()){
                String enunciadoOpcion = opcion.getAsString();
                enunciadosOpciones.agregarEnunciadoEidentificador(Integer.parseInt(identificador), enunciadoOpcion);
            }
        }

        return enunciadosOpciones;
    }
}
