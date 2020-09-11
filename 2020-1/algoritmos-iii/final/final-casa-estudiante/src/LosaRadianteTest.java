import org.junit.Test;

public class LosaRadianteTest {

    @Test
    public void test01creoUnaLosaRadianteYVerificoSuConsumo() {

        LosaRadiante losaRadiante = new LosaRadiante(10, 20);
        org.junit.Assert.assertEquals(losaRadiante.getConsumo(), 2000);
    }
}
