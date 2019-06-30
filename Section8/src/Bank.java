import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public boolean addBranch(String name) {
        Branch branch = getBranch(name);
        if (branch != null) {
            System.out.println("Branch named " + name + " already exists in bank " +
                    this.name + ". Cannot add.");
            return false;
        }

        this.branches.add(new Branch(name));
        System.out.println("New branch " + name + " added to bank " + this.name);
        return true;
    }

    public boolean addCustomerToBranch(String branchName, String customerName,
                                    double initialTransaction) {
        Branch branch = getBranch(branchName);
        if (branch != null) {
            if (branch.addNewCustomer(customerName, initialTransaction)) {
                System.out.println("New customer " + customerName + " added to " +
                        " branch " + branchName + " in bank " + this.name);
                return true;
            }
            return false;
        }

        System.out.println("Branch " + branchName + " does not exists in bank " + this.name);
        return false;
    }

    public boolean addTransactionForCustomer(String branchName, String customerName,
                                          double initialTransaction) {
        Branch branch = getBranch(branchName);
        if (branch != null) {
            if (branch.addTransactionToCustomer(customerName, initialTransaction)) {
                System.out.println("New transaction of " + initialTransaction +
                        " added for customer " + customerName + " in branch " +
                        branchName + " of bank " + this.name);
                return true;
            }
            return false;
        }

        System.out.println("Branch " + branchName + " does not exist in bank " + this.name);
        return false;
    }
//
//    public void showCustomerBalance(String branchName, String customerName) {
//        Branch branch = getBranch(branchName);
//        if (branch == null) {
//            System.out.println("Branch " + branchName +
//                    " does not exist in bank " + this.name);
//            return;
//        }
//
//        Customer customer = branch.getCustomer(customerName);
//        if (customer == null) {
//            System.out.println("Customer " + customerName +
//                    " does not exist in branch " + branchName +
//                    ", bank " + this.name);
//            return;
//        }
//
//        System.out.println(customer.getBalance());
//    }

    public void listBranches(boolean listTransactions) {
        for (Branch branch : branches) {
            System.out.println("Branch " + branch.getName());
            branch.listCustomers(listTransactions);
        }
    }

    private Branch getBranch(String name) {
        for (Branch branch : this.branches) {
            if (branch.getName().equals(name))
                return branch;
        }

        return null;
    }
}
