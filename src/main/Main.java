package main;

import factory.BikeFactory;
import factory.CarFactory;
import factory.VehicleFactory;
import strategy.CardPayment;
import strategy.CashPayment;
import strategy.PaymentContext;
import vehicles.Vehicle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== Vehicle Rental System ===");
        System.out.println("1. Rent Car");
        System.out.println("2. Rent Bike");
        System.out.print("Select vehicle: ");
        int vehicleChoice = input.nextInt();

        VehicleFactory factory = null;

        if (vehicleChoice == 1) {
            factory = new CarFactory();
        } else if (vehicleChoice == 2) {
            factory = new BikeFactory();
        } else {
            System.out.println("Invalid vehicle choice.");
            return;
        }

        Vehicle vehicle = factory.createVehicle();
        vehicle.rent();

        System.out.println("\nSelect Payment Method");
        System.out.println("1. Card Payment");
        System.out.println("2. Cash Payment");
        System.out.print("Enter choice: ");
        int paymentChoice = input.nextInt();

        PaymentContext context = new PaymentContext();

        if (paymentChoice == 1) {
            context.setStrategy(new CardPayment());
        } else if (paymentChoice == 2) {
            context.setStrategy(new CashPayment());
        } else {
            System.out.println("Invalid payment choice.");
            return;
        }

        System.out.print("Enter rental amount: ");
        double amount = input.nextDouble();

        context.processPayment(amount);

        System.out.println("Rental process completed successfully.");
    }
}