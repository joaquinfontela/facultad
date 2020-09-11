import org.junit.Test;

public class EstufaTest {

    @Test
    public void test01creoUnaEstufaYVerificoSuConsumo() {

        Estufa estufa = new Estufa(3, 20, 100);
        org.junit.Assert.assertEquals(estufa.getConsumo(), 6000);
    }
}
