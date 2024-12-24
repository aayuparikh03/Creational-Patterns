package org.example;
// Singleton Class
class Singleton {
    // Step 1: Create a private static variable to hold the single instance
    private static Singleton instance;

    // Step 2: Make the constructor private to prevent instantiation from outside
    private Singleton() {
        System.out.println("Singleton instance created.");
    }

    // Step 3: Provide a public static method to get the single instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton(); // Lazy initialization
        }
        return instance;
    }

    // A sample method to demonstrate the Singleton's functionality
    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}

// Test Singleton
public class Main {
    public static void main(String[] args) {
        // Try to get instances of the Singleton class
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        // Check if both references point to the same object
        System.out.println("Are both instances the same? " + (instance1 == instance2));

        // Call a method on the Singleton instance
        instance1.showMessage();
    }
}
