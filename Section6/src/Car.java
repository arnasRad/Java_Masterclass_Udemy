public class Car extends Vehicle {
    private int doors;
    private String fuelType;
    private double fuelConsumption;
    private int totalGears;
    private int currentGear;
    private double engineVolume;

    public Car(int topSpeed, String name, int size, int yearMade, int doors, String fuelType, double fuelConsumption, int totalGears, double engineVolume) {
        super(topSpeed, name, size, yearMade);
        this.doors = doors;
        this.fuelType = fuelType;
        this.fuelConsumption = fuelConsumption;
        this.totalGears = totalGears;
        this.currentGear = 0;
        this.engineVolume = engineVolume;
    }

    public int getDoors() {
        return doors;
    }

    public String getFuelType() {
        return fuelType;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public int getTotalGears() {
        return totalGears;
    }

    public int getCurrentGear() {
        return currentGear;
    }

    public void setCurrentGear(int currentGear) {
        this.currentGear = currentGear;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    private void changeGears(int gear) {
        if (gear <= totalGears && gear >= 0) {
            currentGear = gear;
            System.out.println("Gear changed to " + gear);
        } else
            System.out.println("Invalid gear");
    }

    private void changeGearsByCurrentSpeed() {
        int currentSpeed = getCurrentVelocity();

        if (currentSpeed == 0)
            changeGears(0);
        else if (currentSpeed < 20)
            changeGears(1);
        else if (currentSpeed < 40)
            changeGears(2);
        else if (currentSpeed < 60)
            changeGears(3);
        else if (currentSpeed < 85)
            changeGears(4);
        else if (currentSpeed < 120)
            changeGears(5);
        else
            changeGears(6);
    }

    private void changeVelocityBy(int speed) {
        int newSpeed = getCurrentVelocity() + speed;
        if (newSpeed <= 0) {
            setCurrentVelocity(0);
            changeGearsByCurrentSpeed();
            System.out.println("Vehicle stopped. Current velocity is " + getCurrentVelocity());
        } else if (newSpeed <= getTopSpeed()) {
            if (speed > 0)
                System.out.println("Speed increased by " + speed);
            else if (speed < 0)
                System.out.println("Speed decreased by " + Math.abs(speed));
            else
                System.out.println("Speed did not change");

            setCurrentVelocity(newSpeed);
            changeGearsByCurrentSpeed();
        } else {
            System.out.println("Vehicle cannot reach speed of " + newSpeed +
                    ", enter a valid speed that is less or equal to " + getTopSpeed());
        }
    }

    public void move(int speed, int direction) {
        changeVelocityBy(speed);
        super.steer(direction);
        move();
    }
}
