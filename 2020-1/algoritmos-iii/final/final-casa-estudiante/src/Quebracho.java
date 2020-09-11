public class Quebracho extends Madera {

    private static final int gradoDePureza = 2;

    public Quebracho(int cantidadEnKg) {
        super(cantidadEnKg);
        precioPorKg = 4;
    }

    @Override
    public int getCosto() {
        return ( cantidadEnKg * precioPorKg * gradoDePureza );
    }
}
