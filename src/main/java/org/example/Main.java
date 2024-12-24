package org.example;

interface Prototype extends Cloneable {
    Prototype clone();
}
class ConcretePrototype implements Prototype {
    private String name;
    private int value;

    public ConcretePrototype(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public Prototype clone() {
        // Deep copy
        return new ConcretePrototype(this.name, this.value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ConcretePrototype [Name=" + name + ", Value=" + value + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an original prototype
        ConcretePrototype original = new ConcretePrototype("Prototype1", 42);

        // Clone the original prototype
        Prototype cloned = original.clone();

        // Modify the cloned object
        ((ConcretePrototype) cloned).setName("ClonedPrototype");
        ((ConcretePrototype) cloned).setValue(99);

        // Display the original and cloned objects
        System.out.println("Original Object: " + original);
        System.out.println("Cloned Object: " + cloned);
    }
}
