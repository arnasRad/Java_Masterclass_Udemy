public class Vehicle {
    private int topSpeed;
    private int currentVelocity;
    private int currentDirection;
    private String name;
    private int size;
    private int yearMade;

    public Vehicle(int topSpeed, String name, int size, int yearMade) {
        this.topSpeed = topSpeed;
        this.currentVelocity = 0;
        this.currentDirection = 0;
        this.name = name;
        this.size = size;
        this.yearMade = yearMade;
    }

    public Vehicle(String name, int size, int yearMade) {
        this(0, name, size, yearMade);
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public int getCurrentVelocity() {
        return currentVelocity;
    }

    public void setCurrentVelocity(int currentVelocity) {
        this.currentVelocity = currentVelocity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getYearMade() {
        return yearMade;
    }

    public void setYearMade(int yearMade) {
        this.yearMade = yearMade;
    }

    public void move() {
        System.out.println("Moving at speed of " + currentVelocity + " in direction of " + currentDirection);
    }

    public void steer(int degrees) {
        if (Math.abs(degrees + currentDirection) > 60) {
            System.out.println("Steering angle " + degrees + " is too big." +
                    " Steering wheel can be turned 60 degrees max.");
            return;
        }

        this.currentDirection += degrees;
        System.out.println("Steering direction changed to " +
                currentDirection + " degrees");
    }
}
