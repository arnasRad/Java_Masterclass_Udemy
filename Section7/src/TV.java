public class TV {
    private boolean power;
    private int activeChannel;
    private int volume;

    public TV(boolean power, int activeChannel, int volume) {
        this.power = power;
        this.activeChannel = activeChannel;
        this.volume = volume;
    }

    private boolean isPower() {
        return power;
    }

    public int getActiveChannel() {
        return activeChannel;
    }

    public void setActiveChannel(int activeChannel) {
        if (activeChannel < 0 || activeChannel > 255)
            System.out.println(activeChannel + " is invalid channel");
        else {
            this.activeChannel = activeChannel;
            System.out.println("TV channel changed to " + activeChannel);
        }

    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume < 0 || volume > 100)
            System.out.println(volume + "is invalid volume");
        else {
            this.volume = volume;
            System.out.println("Volume changed to " + volume);
        }
    }

    public void togglePower() {
        this.power = !this.power;
        if (this.power)
            System.out.println("Router turned on");
        else
            System.out.println("Router turned off");
    }
}
