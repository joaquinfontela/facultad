package Observer;

public class GasolineTank implements Observer {

    private double litresLeft;
    private Accelerator accelerator;

    public GasolineTank(Accelerator accelerator){
        this.accelerator = accelerator;
        litresLeft = 50;
    }

    @Override
    public void update() {
        litresLeft -= ( accelerator.getSecondsPressed() * 0.01 );
    }

    public double getLitresLeft() {
        return litresLeft;
    }
}
