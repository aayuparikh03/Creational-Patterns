package org.example;

// Product Interface
interface Vehicle {
    void drive();
}

// Concrete Product 1
class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a Car!");
    }
}

// Concrete Product 2
class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a Bike!");
    }
}

// Factory (Creator)
class VehicleFactory {
    // Factory method
    public static Vehicle getVehicle(String type) {
        if (type.equalsIgnoreCase("car")) {
            return new Car();
        } else if (type.equalsIgnoreCase("bike")) {
            return new Bike();
        } else {
            throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }
}

// Client
public class Main {
    public static void main(String[] args) {
        // Client requests a Car
        Vehicle car = VehicleFactory.getVehicle("car");
        car.drive();

        // Client requests a Bike
        Vehicle bike = VehicleFactory.getVehicle("bike");
        bike.drive();

        // Invalid request
        try {
            Vehicle unknown = VehicleFactory.getVehicle("plane");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
