package vehicles;

public class Car implements Vehicle {
    @Override
    public void rent() {
        System.out.println("Car rented successfully.");
    }
}