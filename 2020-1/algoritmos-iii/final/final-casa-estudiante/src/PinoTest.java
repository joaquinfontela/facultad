import org.junit.Test;

public class PinoTest {

    @Test
    public void test01creoUnPinoConUnaCantidadDeKgYVerificoElCosto() {

        Pino pino = new Pino(12);
        org.junit.Assert.assertEquals(pino.getCosto(), 8);

    }
}
