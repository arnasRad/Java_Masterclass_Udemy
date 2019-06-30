public class Router {
    private boolean power;
    private int pairedDevices;

    public Router(boolean power) {
        this.power = power;
        this.pairedDevices = 0;
    }

    public boolean isPower() {
        return power;
    }

    public int getPairedDevices() {
        return pairedDevices;
    }

    public void togglePower() {
        this.power = !this.power;
        if (this.power)
            System.out.println("Router turned on");
        else
            System.out.println("Router turned off");
    }

    public void pairDevice() {
        ++pairedDevices;
        System.out.println("New device paired to the router");
    }
}
