public class Room {
    private Lights lights;
    private Heater heater;
    private TV tv;
    private Router router;
    private Thermometer thermometer;

    public Room(Lights lights, Heater heater, TV tv, Router router, Thermometer thermometer) {
        this.lights = lights;
        this.heater = heater;
        this.tv = tv;
        this.router = router;
        this.thermometer = thermometer;
    }

    public Lights getLights() {
        return lights;
    }

    public Heater getHeater() {
        return heater;
    }

    public TV getTv() {
        return tv;
    }

    public Router getRouter() {
        return router;
    }

    public Thermometer getThermometer() {
        return thermometer;
    }

    public void toggleLightsPower() {
        lights.togglePower();
    }

    public void toggleHeaterPower() {
        heater.togglePower();
    }

    public void toggleTVPower() {
        tv.togglePower();
    }

    public void toggleRouterPower() {
        router.togglePower();
    }

    public void changeTVChannel(int channel) {
        tv.setActiveChannel(channel);
    }

    public int getRoomTemperature() {
        return thermometer.getTemperature();
    }

}
