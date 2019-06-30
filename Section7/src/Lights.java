public class Lights {
    private boolean power;

    public Lights() {
        this.power = false;
    }

    public boolean isPower() {
        return power;
    }

    public void togglePower() {
        this.power = !this.power;
        if (this.power)
            System.out.println("Lights turned on");
        else
            System.out.println("Lights turned off");
    }
}
