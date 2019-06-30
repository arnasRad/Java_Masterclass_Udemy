public class Main {
    public static void main(String[] args) {
//        Heater heater = new Heater(false, 2);
//        Lights lights = new Lights();
//        Router router = new Router(true);
//        TV tv = new TV(false, 2, 30);
//        Thermometer thermometer = new Thermometer(23);
//
//        Room room = new Room(lights, heater, tv, router, thermometer);
//
//        System.out.println(room.getRoomTemperature());
//        room.changeTVChannel(32);
//        room.toggleHeaterPower();
//        room.getHeater().changeHeatLevel(4);

//        Printer printer = new Printer(11, false);
//        printer.print(12);
//        printer.showPagesPrintedCount();
//        printer.fillToner(-1);
//        printer.print(7);
//        printer.showPagesPrintedCount();

        Hamburger hamburger = new Hamburger("flour bread", "beef");
        hamburger.addAdditions("lettuce", "onion",
                "cheese", "tomato");

        Hamburger healthyHamburger = new HealthyBurger("beef");
        ((HealthyBurger) healthyHamburger).addAdditions("lettuce", "onion",
                "cheese", "tomato",
                "bacon", "dried onion");

        Hamburger deluxeHamburger = new DeluxeBurger("flour bread", "beef");
        deluxeHamburger.addAdditions("lettuce", "dried onion",
                "cheese", "cucumber");

        hamburger.printBurgerInfo();
        healthyHamburger.printBurgerInfo();
        deluxeHamburger.printBurgerInfo();

    }
}
