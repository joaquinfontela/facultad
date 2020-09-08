package FactoryMethod;

public class Main {

    public static void main(String[] args) {

        VehicleFactory vehicleFactory = new VehicleFactory();

        Vehicle truck = vehicleFactory.getVehicle("T");
        truck.accelerate();
        truck.accelerate();
        truck.pressBreak();
        System.out.println(truck.getSpeed() == 1);

        Vehicle motorbike = vehicleFactory.getVehicle("M");
        motorbike.accelerate();
        motorbike.accelerate();
        motorbike.pressBreak();
        System.out.println(motorbike.getSpeed() == 4);

        Vehicle car = vehicleFactory.getVehicle("C");
        car.accelerate();
        car.accelerate();
        car.accelerate();
        System.out.println(car.getSpeed() == 6);

        System.out.println(vehicleFactory.getVehicle("OtherString") == null);

    }
}
