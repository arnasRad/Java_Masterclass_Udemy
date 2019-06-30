class Car {
    private String name;
    private boolean engine;
    private int cylinders;
    private int wheels;
    private int currentVelocity;
    private int topSpeed;

    public Car(String name, int cylinders, int topSpeed) {
        this.name = name;
        this.engine = false;
        this.cylinders = cylinders;
        this.wheels = 4;
        this.currentVelocity = 0;
        this.topSpeed = topSpeed;
    }

    public String getName() {
        return name;
    }

    public boolean isEngine() {
        return engine;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getWheels() {
        return wheels;
    }

    public int getCurrentVelocity() {
        return currentVelocity;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void startEngine() {
        if (!this.engine) {
            this.engine = true;
            System.out.println("Engine started");
        } else {
            System.out.println("Engine was already started");
        }
    }

    public void stopEngine() {
        if (this.engine) {
            this.engine = false;
            System.out.println("Engine stopped");
        } else {
            System.out.println("Engine was already stopped");
        }
    }

    public void accelerate(int velocity) {
        if (velocity < 0) {
            System.out.println("Invalid velocity entered for acceleration. Positive number needed.");
            return;
        }

        int newVelocity = this.currentVelocity + velocity;
        if (newVelocity > topSpeed) {
            System.out.println("Cannot reach higher velocity than top speed of the car");
            return;
        } else {
            this.currentVelocity = newVelocity;
            System.out.println("Car accelerated. New velocity: " + currentVelocity);
        }
    }

    public void brake(int velocity) {
        if (velocity < 0) {
            System.out.println("Positive number required as brake input");
            return;
        }

        int newVelocity = this.currentVelocity - velocity;
        if (newVelocity <= 0) {
            this.currentVelocity = 0;
            System.out.println("Car stopped");
        } else {
            this.currentVelocity = newVelocity;
            System.out.println("Car velocity reduced to " + newVelocity);
        }
    }
}

class Passat extends Car {
    public Passat() {
        super("Volkswagen Passat", 4, 210);
    }

    @Override
    public void stopEngine() {
        super.stopEngine();
        System.out.println("Passat cannot accelerate now");
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println("Passat can accelerate now");
    }

    @Override
    public void accelerate(int velocity) {
        super.accelerate(velocity);
        System.out.println("Passat reached " +
                ((double)getCurrentVelocity() / (double)getTopSpeed()) + "% top speed");
    }

    @Override
    public void brake(int velocity) {
        super.brake(velocity);
        System.out.println("Passat is going at " +
                 ((double)getCurrentVelocity() / (double)getTopSpeed()) + "% top speed");
    }
}

class s60 extends Car {
    public s60() {
        super("Volvo s60", 4, 215);
    }

    @Override
    public void stopEngine() {
        super.stopEngine();
        System.out.println("s60 cannot accelerate now");
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println("s60 can accelerate now");
    }

    @Override
    public void accelerate(int velocity) {
        super.accelerate(velocity);
        System.out.println("s60 reached " +
                ((double) getCurrentVelocity() / (double)getTopSpeed()) + "% top speed");
    }

    @Override
    public void brake(int velocity) {
        super.brake(velocity);
        System.out.println("s60 is going at " +
                ((double) getCurrentVelocity() / (double)getTopSpeed()) + "% top speed");
    }
}

class Omega extends Car {
    public Omega() {
        super("Opel Omega", 4, 210);
    }

    @Override
    public void stopEngine() {
        super.stopEngine();
        System.out.println("Omega cannot accelerate now");
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println("Omega can accelerate now");
    }

    @Override
    public void accelerate(int velocity) {
        super.accelerate(velocity);
        System.out.println("Omega reached " +
                ((double) getCurrentVelocity() / (double)getTopSpeed()) + "% top speed");
    }

    @Override
    public void brake(int velocity) {
        super.brake(velocity);
        System.out.println("Omega is going at " +
                ((double) getCurrentVelocity() / (double)getTopSpeed()) + "% top speed");
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; ++i) {
            System.out.println("#" + i + " iteration:");
            Car car = getRandomCar();
            car.getTopSpeed();
            car.startEngine();
            car.accelerate(100);
            car.brake(100);
            car.stopEngine();

            System.out.println("");
            System.out.println("");
        }
    }

    private static Car getRandomCar() {
        int randInt = (int) (Math.random() * 3) + 1;
        System.out.println("Random number generated: " + randInt);

        switch (randInt) {
            case 1:
                return new Passat();
            case 2:
                return new s60();
            case 3:
                return new Omega();
        }

        return null;
    }

}