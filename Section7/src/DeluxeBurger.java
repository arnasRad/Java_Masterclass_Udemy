public class DeluxeBurger extends Hamburger {
    private double chipsPrice = 1;
    private double drinkPrice = 1;

    public DeluxeBurger(String rollType, String meat) {
        super(rollType, meat);
        appendTotalPrice(chipsPrice);
        appendTotalPrice(drinkPrice);
    }

    public double getChipsPrice() {
        return chipsPrice;
    }

    public double getDrinkPrice() {
        return drinkPrice;
    }

    @Override
    public void printAdditionInfo() {
        super.printAdditionInfo();
        System.out.println("Chips: " + chipsPrice + "$");
        System.out.println("Drink: " + drinkPrice + "$");
    }

    @Override
    public void printTotalPrice() {
        System.out.println("Total price: " + getPrice() + "$");
    }

    @Override
    public void printBurgerInfo() {
        System.out.println("Deluxe burger info:");
        super.printBurgerBaseInfo();
        this.printAdditionInfo();
        this.printTotalPrice();
        System.out.println();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }
}
