/**
 * Component: Engine
 */
class Engine {
    public void turnOn() {
        System.out.println("Engine is now running.");
    }
}

/**
 * Component: Ignition 
 */
class Ignition {
    public void start(Engine engine) {
        System.out.print("Ignition: Sparking... ");
        engine.turnOn(); 
    }
}

/**
 * Component: Brake
 */
class Brake {
    public void apply() {
        System.out.println("Brakes applied.");
    }
}

/**
 * Abstraction: The base Vehicle blueprint
 */
abstract class Vehicle {
    protected String model;
    protected Engine engine = new Engine();       
    protected Ignition ignition = new Ignition(); 
    protected Brake brake = new Brake();          

    public Vehicle(String model) {
        this.model = model;
    }

    public abstract void run();  
    public abstract void stop(); 
}

/**
 * Inheritance: Specific Car implementation
 */
class Car extends Vehicle {
    public Car(String model) { super(model); }

    @Override
    public void run() {
        System.out.println("Car " + model + " starting:");
        ignition.start(engine);
    }

    @Override
    public void stop() {
        brake.apply();
        System.out.println("Car stopped.");
    }
}

/**
 * Inheritance: Specific Cycle implementation
 */
class Cycle extends Vehicle {
    public Cycle(String model) { super(model); }

    @Override
    public void run() {
        System.out.println("Cycle " + model + " starting: Pedaling now!");
    }

    @Override
    public void stop() {
        brake.apply();
        System.out.println("Cycle stopped.");
    }
}

/**
 * Factory: Handles object creation
 */
class VehicleFactory {
    public static Vehicle createVehicle(String type, String model) {
        if (type.equalsIgnoreCase("car")) return new Car(model);
        if (type.equalsIgnoreCase("cycle")) return new Cycle(model);
        return null;
    }
}

/**
 * Main Application
 */
public class Main {
    public static void main(String[] args) {
        Vehicle myCar = VehicleFactory.createVehicle("car", "Toyota");
        Vehicle myCycle = VehicleFactory.createVehicle("cycle", "Mountain Bike");

        myCar.run();
        myCar.stop();

        

        myCycle.run();
        myCycle.stop();
    }
}
