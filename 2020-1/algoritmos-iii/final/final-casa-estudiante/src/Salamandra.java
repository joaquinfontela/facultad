import java.util.ArrayList;

public class Salamandra implements GeneradorDeGastos {

    private int metrosCuadrados;
    private int kgDeMaderaContenidos;
    private static final int maxKgDeMadera = 15;
    private ArrayList<Madera> maderas;

    public Salamandra(int metrosCuadrados){
        kgDeMaderaContenidos = 0;
        maderas = new ArrayList<>();
        this.metrosCuadrados = metrosCuadrados;
    }

    public void agregarMadera(Madera madera) {
        if ( sePuedeAgregarLaMadera(madera) ) {
            maderas.add(madera);
            kgDeMaderaContenidos += madera.getCantidadEnKg();
        } else {
            throw new CapacidadParaMaderaAgotadaException();
        }
    }

    private boolean sePuedeAgregarLaMadera(Madera madera) {
        return ((maxKgDeMadera - kgDeMaderaContenidos) >= madera.getCantidadEnKg());
    }

    @Override
    public int getConsumo() {
        int consumo = 0;

        for (Madera m : maderas) {
            consumo += m.getCosto();
        }

        return ( consumo * metrosCuadrados );
    }
}
