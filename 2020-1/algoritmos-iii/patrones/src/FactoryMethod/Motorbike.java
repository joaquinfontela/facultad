package FactoryMethod;

public class Motorbike extends Vehicle {

    @Override
    public void accelerate() {

        speed += 3;
    }

    @Override
    public void pressBreak() {

        speed -= 2;
    }
}
