import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class SalamandraTest {

    @Test
    public void test01CreoUnaSalamandraYVerificoQueSuGastoInicialSea0() {
        Salamandra salamandra = new Salamandra(10);
        org.junit.Assert.assertEquals(salamandra.getConsumo(), 0);
    }

    @Test (expected = CapacidadParaMaderaAgotadaException.class)
    public void test02IntentoAgregarMasde15KgDeUnaSolaVezYLanzaExcepcion() {
        Salamandra salamandra = new Salamandra(10);
        salamandra.agregarMadera(new Quebracho(16));
    }

    @Test (expected = CapacidadParaMaderaAgotadaException.class)
    public void test03IntentoAgregarMasDe15KgYLanzaExcepcion() {
        Salamandra salamandra = new Salamandra(10);
        salamandra.agregarMadera(new Pino(10));
        salamandra.agregarMadera(new Quebracho(4));
        salamandra.agregarMadera(new Quebracho(2));
    }

    @Test
    public void test04AgregoMaderaYCalculoElConsumo() {
        Salamandra salamandra = new Salamandra(10);
        salamandra.agregarMadera(new Pino(6));
        salamandra.agregarMadera(new Quebracho(5));
        org.junit.Assert.assertEquals(salamandra.getConsumo(), 440);
    }

    @Test
    public void test05agregoMaderaYCalculoElConsumo() {
        Salamandra salamandra = new Salamandra(20);
        salamandra.agregarMadera(new Pino(9));
        salamandra.agregarMadera(new Quebracho(6));
        org.junit.Assert.assertEquals(salamandra.getConsumo(), 1080);
    }
}
