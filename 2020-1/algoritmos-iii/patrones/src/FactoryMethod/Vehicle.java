package FactoryMethod;

public abstract class Vehicle {

    protected boolean engineOn = false;
    protected int speed = 0;

    public int getSpeed() {

        return speed;
    }

    public void turnOnEngine(){

        engineOn = true;
    }

    public abstract void accelerate();

    public abstract void pressBreak();
}
