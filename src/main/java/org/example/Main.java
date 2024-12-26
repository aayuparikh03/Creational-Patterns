package org.example;

// Abstract Product A
interface Button {
    void render();
}

// Abstract Product B
interface Checkbox {
    void render();
}

// Concrete Product A1
class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a Windows Button.");
    }
}

// Concrete Product B1
class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a Windows Checkbox.");
    }
}

// Concrete Product A2
class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a Mac Button.");
    }
}

// Concrete Product B2
class MacCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a Mac Checkbox.");
    }
}

// Abstract Factory
interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factory 1
class WindowsFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

// Concrete Factory 2
class MacFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

// Client
class Application {
    private final Button button;
    private final Checkbox checkbox;

    public Application(UIFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void renderUI() {
        button.render();
        checkbox.render();
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Use Windows UI Factory
        UIFactory windowsFactory = new WindowsFactory();
        Application windowsApp = new Application(windowsFactory);
        System.out.println("Windows UI:");
        windowsApp.renderUI();

        // Use Mac UI Factory
        UIFactory macFactory = new MacFactory();
        Application macApp = new Application(macFactory);
        System.out.println("\nMac UI:");
        macApp.renderUI();
    }
}
