package FactoryMethod;

public class VehicleFactory {

    public Vehicle getVehicle(String vehicleId) {

        vehicleId = vehicleId.toUpperCase();

        switch (vehicleId) {

            case("C"):
                return new Car();

            case("M"):
                return new Motorbike();

            case("T"):
                return new Truck();

            default:
                return null;
        }
    }
}
