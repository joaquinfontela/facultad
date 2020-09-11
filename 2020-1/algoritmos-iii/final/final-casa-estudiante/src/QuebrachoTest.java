import org.junit.Test;

public class QuebrachoTest {

    @Test
    public void test01creoUnQuebrachoConUnaCantidadDeKgYVerificoElCosto() {

        Quebracho quebracho = new Quebracho(12);
        org.junit.Assert.assertEquals(quebracho.getCosto(), 96);

    }
}
