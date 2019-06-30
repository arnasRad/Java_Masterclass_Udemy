public class Passat extends Car {
    private double cost;
    private boolean autopilot;

    public Passat(int topSpeed, int size, int yearMade, String fuelType,
                  double fuelConsumption, int gears, double engineVolume,
                  double cost, boolean autopilot) {
        super(topSpeed, "Volkswagen Passat", size, yearMade, 4,
                fuelType, fuelConsumption, gears, engineVolume);
        this.cost = cost;
        this.autopilot = autopilot;
    }

    public Passat(int topSpeed, int size, int yearMade,
                  double fuelConsumption, double cost, double engineVolume) {
        super(topSpeed, "Volkswagen Passat", size, yearMade, 4,
                "Diesel", fuelConsumption, 5, 1.9);
        this.cost = cost;
        this.autopilot = false;
    }

    public double getCost() {
        return cost;
    }

    public boolean isAutopilot() {
        return autopilot;
    }
}
