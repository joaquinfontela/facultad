package Observer;

public class Car implements Observer {

    private Accelerator accelerator;
    private GasolineTank gasolineTank;
    private int speed;

    public Car(Accelerator accelerator) {

        this.accelerator = accelerator;

        this.gasolineTank = new GasolineTank(this.accelerator);
        this.accelerator.addObserver(gasolineTank);

        speed = 0;
    }

    @Override
    public void update() {
        speed += ( accelerator.getSecondsPressed() * 5 );
    }

    public int getSpeed() {
        return speed;
    }

    public double gasolineLitresLeft() {
        return gasolineTank.getLitresLeft();
    }
}
