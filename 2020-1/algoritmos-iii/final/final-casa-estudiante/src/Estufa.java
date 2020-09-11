public class Estufa implements ComponenteElectrico {

    private int ambientes;
    private int precioKw;
    private int calorias;

    public Estufa(int ambientes, int precioKw, int calorias) {
        this.ambientes = ambientes;
        this.precioKw = precioKw;
        this.calorias = calorias;
    }

    @Override
    public int getConsumo() {
        return ( ambientes * precioKw * calorias );
    }
}
