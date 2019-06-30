public class BurgerAddition {
    private String addition;
    private double additionPrice;

    public BurgerAddition(String addition) {
        this.addition = addition;
        this.additionPrice = getAdditionPrice();
    }

    public String getAddition() {
        return addition;
    }

    private void setAddition(String addition) {
        this.addition = addition;
    }

    public double getPrice() {
        return additionPrice;
    }

    public String getAdditionInfo() {
        return addition + ", " + additionPrice + "$";
    }

    private double getAdditionPrice() {
        String additionLowercase = addition.toLowerCase();
        switch (additionLowercase) {
            case "lettuce":
                return 0.3;
            case "tomato":
                return 0.3;
            case "onion":
                return 0.3;
            case "pickle":
                return 0.4;
            case "cucumber":
                return 0.4;
            case "cheese":
                return 0.5;
            case "bacon":
                return 0.6;
            case "dried onion":
                return 0.3;
            default:
                System.out.println("Invalid addition " + additionLowercase + " selected. " +
                        "Available options: lettuce, tomato, onion, pickle, " +
                        "cucumber, cheese, bacon, dried onion.");
                setAddition("Unknown addition");
                return -1;
        }
    }
}
