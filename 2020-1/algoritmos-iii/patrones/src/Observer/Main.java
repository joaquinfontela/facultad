package Observer;

public class Main {

    public static void main(String[] args) {

        Accelerator accelerator = new Accelerator();

        Car car = new Car(accelerator);
        accelerator.addObserver(car);

        accelerator.press(5);

        System.out.println(car.getSpeed());
        System.out.println(car.gasolineLitresLeft());

        accelerator.press(15);

        System.out.println(car.getSpeed());
        System.out.println(car.gasolineLitresLeft());
    }
}
