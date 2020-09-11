public abstract class Madera implements Costeable {

    protected int cantidadEnKg;
    protected int precioPorKg;

    public Madera(int cantidadEnKg) {
        this.cantidadEnKg = cantidadEnKg;
    }

    public int getCantidadEnKg() {
        return cantidadEnKg;
    }
}
