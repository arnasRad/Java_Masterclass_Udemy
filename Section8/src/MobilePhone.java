public class MobilePhone {
    private ContactList contactList;

    public MobilePhone() {
        this.contactList = new ContactList();
    }

    public void startMenu() {
        System.out.println("/*** MENU ***/");
        System.out.println("1. Contact list");
        System.out.println("2. New contact");
        System.out.println("3. Modify contact");
        System.out.println("4. Remove contact");
        System.out.println("5. Search contacts");
        System.out.println("0. Quit");

        int option;
        while (true) {
            System.out.println("Enter option: ");
            option = Utils.getIntInput();

            if (option >= 0 && option <= 5)
                break;
            else
                System.out.println("Enter integer from 1 to 5 inclusive");
        }

        System.out.println();
        startActivity(option);
    }

    private void startActivity(int option) {
        switch (option) {
            case 1:
                contactList.printContacts();
                startMenu();
                break;
            case 2:
                contactList.addContact();
                startMenu();
                break;
            case 3:
                contactList.modifyContact();
                startMenu();
                break;
            case 4:
                contactList.removeContact();
                startMenu();
                break;
            case 5:
                contactList.findContact();
                startMenu();
                break;
            case 0:
                System.out.println("Closing program");
                break;
            default:
                System.out.println("Invalid option");
                startMenu();
                break;
        }
    }
}
