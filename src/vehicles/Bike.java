package vehicles;

public class Bike implements Vehicle {
    @Override
    public void rent() {
        System.out.println("Bike rented successfully.");
    }
}