package FactoryMethod;

public class Car extends Vehicle {

    @Override
    public void accelerate() {

        speed += 2;
    }

    @Override
    public void pressBreak() {

        speed -= 2;
    }
}
