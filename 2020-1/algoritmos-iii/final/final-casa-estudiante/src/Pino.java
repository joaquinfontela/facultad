public class Pino extends Madera {

    private static final int coeficienteCalorico = 3;

    public Pino(int cantidadEnKg) {
        super(cantidadEnKg);
        precioPorKg = 2;
    }

    @Override
    public int getCosto() {
        return (( cantidadEnKg * precioPorKg ) / coeficienteCalorico );
    }
}
