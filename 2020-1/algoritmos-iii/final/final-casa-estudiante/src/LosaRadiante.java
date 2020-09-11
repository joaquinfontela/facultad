public class LosaRadiante implements ComponenteElectrico {

    private int metros;
    private int precioKw;

    public LosaRadiante(int metros, int precioKw) {
        this.metros = metros;
        this.precioKw = precioKw;
    }

    @Override
    public int getConsumo() {
        return ( precioKw * metros * metros );
    }
}
