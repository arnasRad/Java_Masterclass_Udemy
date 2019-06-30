import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>();

    public Branch(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addNewCustomer(String name, double initialTransaction) {
        Customer customer = getCustomer(name);
        if (customer != null) {
            System.out.println("Customer named " + name + " already exists in branch " +
                    this.name + ". Cannot add.");
            return false;
        }

        customers.add(new Customer(name, initialTransaction));
        //System.out.println("New customer added to branch " + this.name);
        return true;
    }

    public boolean addNewCustomer(String name) {
        Customer customer = getCustomer(name);
        if (customer != null) {
            System.out.println("Customer named " + name + " already exists in branch " +
                    this.name + ". Cannot add.");
            return false;
        }

        customers.add(new Customer(name));
        //System.out.println("New customer added to branch " + this.name);
        return true;
    }

    public boolean addTransactionToCustomer(String name, double transaction) {
        Customer customer = getCustomer(name);
        if (customer == null) {
            System.out.println("Customer " + name + " does not exist for branch " +
                    this.name + " in system. " + "Cannot add transaction");
            return false;
        }

        customer.addTransaction(transaction);
//        System.out.println("Transaction of " + transaction +
//                " added to customer " + name + " account in branch " + this.name);
        return true;
    }

    public void listCustomers(boolean listTransactions) {
        for (Customer customer : customers) {
            System.out.println("- Customer " + customer.getName());
            if (listTransactions)
                customer.listTransactions();
        }
    }

    public Customer getCustomer(String name) {
        for (Customer customer : this.customers) {
            if (customer.getName().equals(name))
                return customer;
        }

        return null;
    }
}
