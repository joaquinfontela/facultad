import org.junit.Test;

public class CasaTest {

    @Test
    public void test01creoUnaCasaLeAgregoGeneradoresDeGastosYVerificoGastoTotal() {
        Casa casa =  new Casa();

        ComponenteElectrico estufaDelBanio = new Estufa(1, 10, 1000);
        casa.agregarGeneradorDeGastos(estufaDelBanio);

        ComponenteElectrico losaComedor = new LosaRadiante(10, 10);
        casa.agregarGeneradorDeGastos(losaComedor);

        ComponenteElectrico cercoFondo = new CercoElectrico(10, 10);
        casa.agregarGeneradorDeGastos(cercoFondo);

        org.junit.Assert.assertEquals(11100, casa.getGastoTotal());
    }

    @Test
    public void test02creoUnaCasaLeAgregoGeneradoresDeGastosYVerificoGastoTotal() {

        Casa casa = new Casa();

        Salamandra salamandra = new Salamandra(25);
        salamandra.agregarMadera(new Pino(9));
        salamandra.agregarMadera(new Quebracho(6));
        casa.agregarGeneradorDeGastos(salamandra);

        casa.agregarGeneradorDeGastos(new LosaRadiante(10, 10));
        casa.agregarGeneradorDeGastos(new CercoElectrico(10, 10));
        casa.agregarGeneradorDeGastos(new Estufa(1, 10, 1000));

        org.junit.Assert.assertEquals(casa.getGastoTotal(), 12450);
    }

}
