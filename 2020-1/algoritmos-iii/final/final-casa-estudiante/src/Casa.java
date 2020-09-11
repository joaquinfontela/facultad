import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Casa {

    private ArrayList<GeneradorDeGastos> generadoresDeGastos;

    public Casa() {
        generadoresDeGastos = new ArrayList<>();
    }

    public int getGastoTotal() {

        int gasto = 0;

        for ( GeneradorDeGastos g : generadoresDeGastos ) {
            gasto += g.getConsumo();
        }

        return gasto;
    }

    public void agregarGeneradorDeGastos(GeneradorDeGastos g) {
        generadoresDeGastos.add(g);
    }

}

