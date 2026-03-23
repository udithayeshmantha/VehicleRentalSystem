package factory;

import vehicles.Bike;
import vehicles.Vehicle;

public class BikeFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Bike();
    }
}