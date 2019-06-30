import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public Customer(String name, double transaction) {
        this.name = name;
        this.transactions.add(transaction);
    }

    public String getName() {
        return name;
    }

    public double getTransaction(int index) {
        return this.transactions.get(index);
    }

    public void addTransaction(double transaction) {
        this.transactions.add(transaction);
    }

    public void listTransactions() {
        int i = 1;
        for (Double transaction : transactions) {
            System.out.println("  [" + i + "] " + transaction);
            ++i;
        }
    }
}
