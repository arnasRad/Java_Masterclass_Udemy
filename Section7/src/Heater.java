public class Heater {
    private boolean power;
    private int level;

    public Heater(boolean power, int level) {
        this.power = power;
        changeHeatLevel(level);
    }

    public boolean isPower() {
        return power;
    }

    private int getLevel() {
        return level;
    }

    public void togglePower() {
        this.power = !this.power;
        if (this.power)
            System.out.println("Heater turned on");
        else
            System.out.println("Heater turned off");
    }

    public void changeHeatLevel(int level) {
        if (level > 5 || level < 0)
            this.level = 0;
        else
            this.level = level;
    }
}
