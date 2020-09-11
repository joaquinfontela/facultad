import org.junit.Test;

public class CercoElectricoTest {

    @Test
    public void test01creoUnCercoElectricoYVerificoSuConsumo() {

        CercoElectrico cercoElectrico = new CercoElectrico(10, 20);
        org.junit.Assert.assertEquals(cercoElectrico.getConsumo(), 200);
    }
}
