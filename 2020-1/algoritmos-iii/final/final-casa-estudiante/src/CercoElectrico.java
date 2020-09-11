public class CercoElectrico implements ComponenteElectrico {

    private int metros;
    private int precioKw;

    public CercoElectrico(int metros, int precioKw) {
        this.metros = metros;
        this.precioKw = precioKw;
    }

    @Override
    public int getConsumo() {
        return ( metros * precioKw );
    }
}
