package FactoryMethod;

public class Truck extends Vehicle {

    @Override
    public void accelerate() {
        speed += 1;
    }

    @Override
    public void pressBreak() {
        speed -= 1;
    }
}
