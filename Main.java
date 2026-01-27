
class Engine {
    public void turnOn() {
        System.out.println("Engine is now running.");
    }
}


class Ignition {
    public void start(Engine engine) {
        System.out.print("Ignition: Sparking ");
        engine.turnOn(); 
    }
}


class Brake {
    public void apply() {
        System.out.println("Brakes applied.");
    }
}


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


class VehicleFactory {
    public static Vehicle createVehicle(String type, String model) {
        if (type.equalsIgnoreCase("car")) return new Car(model);
        if (type.equalsIgnoreCase("cycle")) return new Cycle(model);
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle myCar = VehicleFactory.createVehicle("car", "Toyota");
        Vehicle myCycle = VehicleFactory.createVehicle("cycle", "Mountain Bike");

        myCar.run();
        myCar.stop();

        System.out.println("---");

        myCycle.run();
        myCycle.stop();
    }
}
