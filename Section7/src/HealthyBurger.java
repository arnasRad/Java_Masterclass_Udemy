public class HealthyBurger extends Hamburger {
    private BurgerAddition fifthAddition;
    private BurgerAddition sixthAddition;

    public HealthyBurger(String meat) {
        super(3.5, "brown rye bread", meat);
    }

    public void addFifthAddition(String fifthAddition) {
        BurgerAddition addition = new BurgerAddition(fifthAddition);
        double additionPrice = addition.getPrice();

        if (additionPrice != -1) {
            this.fifthAddition = new BurgerAddition(fifthAddition);
            appendTotalPrice(additionPrice);
        }

//        this.fifthAddition = new BurgerAddition(fifthAddition);
//        appendTotalPrice(this.fifthAddition.getPrice());
    }

    public void addSixthAddition(String sixthAddition) {
        BurgerAddition addition = new BurgerAddition(sixthAddition);
        double additionPrice = addition.getPrice();

        if (additionPrice != -1) {
            this.sixthAddition = new BurgerAddition(sixthAddition);
            appendTotalPrice(additionPrice);
        }

//        this.sixthAddition = new BurgerAddition(sixthAddition);
//        appendTotalPrice(this.sixthAddition.getPrice());
    }

    public void addAdditions(String firstAddition, String secondAddition,
                             String thirdAddition, String fourthAddition,
                             String fifthAddition, String sixthAddition) {
        super.addAdditions(firstAddition, secondAddition, thirdAddition, fourthAddition);
        if (!fifthAddition.equals(""))
            addFifthAddition(fifthAddition);
        if (!sixthAddition.equals(""))
            addSixthAddition(sixthAddition);
    }

    @Override
    public void printAdditionInfo() {
        super.printAdditionInfo();
        if (fifthAddition != null)
            System.out.println("Fifth addition: " + fifthAddition.getAdditionInfo());
        if (sixthAddition != null)
            System.out.println("Sixth addition: " + sixthAddition.getAdditionInfo());
    }

    @Override
    public void printTotalPrice() {
        System.out.println("Total price: " + getPrice() + "$");
    }

    @Override
    public void printBurgerInfo() {
        System.out.println("Healthy burger info:");
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
