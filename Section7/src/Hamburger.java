public class Hamburger {
    private double basePrice = 3.0;
    private double totalPrice;
    private String rollType;
    private String meat;
    private BurgerAddition firstAddition;
    private BurgerAddition secondAddition;
    private BurgerAddition thirdAddition;
    private BurgerAddition fourthAddition;

    public Hamburger(String rollType, String meat) {
        this.totalPrice = basePrice;
        this.rollType = rollType;
        this.meat = meat;
    }

    public Hamburger(double basePrice, String rollType, String meat) {
        this.basePrice = basePrice;
        this.totalPrice = basePrice;
        this.rollType = rollType;
        this.meat = meat;
    }

    public void addAdditions(String firstAddition, String secondAddition,
                             String thirdAddition, String fourthAddition) {
        if (!firstAddition.equals(""))
            addFirstAddition(firstAddition);
        if (!secondAddition.equals(""))
            addSecondAddition(secondAddition);
        if (!thirdAddition.equals(""))
            addThirdAddition(thirdAddition);
        if (!fourthAddition.equals(""))
            addFourthAddition(fourthAddition);
    }

    public void addFirstAddition(String firstAddition) {
        BurgerAddition addition = new BurgerAddition(firstAddition);
        double additionPrice = addition.getPrice();

        if (additionPrice != -1) {
            this.firstAddition = new BurgerAddition(firstAddition);
            this.totalPrice += additionPrice;
        }
    }

    public void addSecondAddition(String secondAddition) {
        BurgerAddition addition = new BurgerAddition(secondAddition);
        double additionPrice = addition.getPrice();

        if (additionPrice != -1) {
            this.secondAddition = new BurgerAddition(secondAddition);
            this.totalPrice += additionPrice;
        }

//        BurgerAddition addition = new BurgerAddition(firstAddition);
//        this.secondAddition = new BurgerAddition(secondAddition);
//        this.totalPrice += this.secondAddition.getPrice();
    }

    public void addThirdAddition(String thirdAddition) {
        BurgerAddition addition = new BurgerAddition(thirdAddition);
        double additionPrice = addition.getPrice();

        if (additionPrice != -1) {
            this.thirdAddition = new BurgerAddition(thirdAddition);
            this.totalPrice += additionPrice;
        }

//        BurgerAddition addition = new BurgerAddition(firstAddition);
//        this.thirdAddition = new BurgerAddition(thirdAddition);
//        this.totalPrice += this.thirdAddition.getPrice();
    }

    public void addFourthAddition(String fourthAddition) {
        BurgerAddition addition = new BurgerAddition(fourthAddition);
        double additionPrice = addition.getPrice();

        if (additionPrice != -1) {
            this.fourthAddition = new BurgerAddition(fourthAddition);
            this.totalPrice += additionPrice;
        }

//        BurgerAddition addition = new BurgerAddition(firstAddition);
//        this.fourthAddition = new BurgerAddition(fourthAddition);
//        this.totalPrice += this.fourthAddition.getPrice();
    }

    public void appendTotalPrice(double price) {
        if (price < 0) {
            System.out.println("Cannot increase burger price by negative value");
            return;
        }

        this.totalPrice += price;
    }

    public void printBurgerBaseInfo() {
        System.out.println("Roll type: " + rollType);
        System.out.println("Meat: " + meat);
        System.out.println("Base price: " + basePrice + "$");
    }

    public void printAdditionInfo() {
        if (firstAddition != null)
            System.out.println("First addition: " + firstAddition.getAdditionInfo());
        if (secondAddition != null)
            System.out.println("Second addition: " + secondAddition.getAdditionInfo());
        if (thirdAddition != null)
            System.out.println("Third addition: " + thirdAddition.getAdditionInfo());
        if (fourthAddition != null)
            System.out.println("Fourth addition: " + fourthAddition.getAdditionInfo());
    }

    public void printTotalPrice() {
        System.out.println("Total price: " + getPrice() + "$");
    }

    public void printBurgerInfo() {
        System.out.println("Hamburger info:");
        printBurgerBaseInfo();
        printAdditionInfo();
        printTotalPrice();
        System.out.println();
    }

    public double getPrice() {
        return totalPrice;
    }
}
