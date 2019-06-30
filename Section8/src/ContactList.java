import java.util.ArrayList;

public class ContactList {
    private ArrayList<Contact> contacts = new ArrayList<>();

    public void printContacts() {
        System.out.println("/*** CONTACTS ***/");
        for (int i = 0; i < contacts.size(); ++i) {
            System.out.println("#" + (i+1) + " contact:");
            contacts.get(i).printContactInfo();
        }
        System.out.println("/*** ***/");
        System.out.println();
    }

    public void addContact() {
        System.out.println("/*** CREATE ***/");
        System.out.println("Enter contact name: ");
        String name = Utils.getStringInput(Contact.NAME_LENGTH);
        int position = getContactPosition(name);
        if (position != -1) {
            System.out.println("Contact " + name + " already exists");
            return;
        }

        System.out.println("Enter phone number: ");
        String phoneNumber = Utils.getStringInput(Contact.PHONE_NUMBER_LENGTH);
        this.contacts.add(new Contact(name, phoneNumber));
        System.out.println("New contact added to contact list");
    }

    public void modifyContact() {
        System.out.println("/*** EDIT ***/");
        System.out.println("Enter contact name you wish to edit:");
        String name = Utils.getStringInput(Contact.NAME_LENGTH);
        Contact contact = getContact(name);
        if (contact != null) {
            System.out.println("Enter new contact name: ");
            name = Utils.getStringInput(Contact.NAME_LENGTH);
            Contact tempContact = getContact(name);
            if (tempContact != null) {
                System.out.println("Name " + name + " already exists. Cannot update contact");
                return;
            }

            System.out.println("Enter new contact phone number: ");
            String phoneNumber = Utils.getStringInput(Contact.PHONE_NUMBER_LENGTH);
            contact.setNewContactInfo(name, phoneNumber);
            System.out.println("Contact modified");
        } else {
            System.out.println("Contact " + name + " does not exist in contact list.");
        }
    }

    public void removeContact() {
        System.out.println("/*** DELETE ***/");
        System.out.println("Enter contact name you wish to remove:");
        String name = Utils.getStringInput(Contact.NAME_LENGTH);
        Contact contact = getContact(name);
        if (contact != null) {
            this.contacts.remove(contact);
            System.out.println("Contact " + name + " removed successfully");
        } else {
            System.out.println("Contact " + name + " does not exist in contact list");
        }
    }

    public void findContact() {
        System.out.println("/*** SEARCH ***/");
        System.out.println("Enter contact name you wish to find:");
        String name = Utils.getStringInput(Contact.NAME_LENGTH);
        int position = getContactPosition(name);
        if (position != -1) {
            System.out.println("Contact " + name + " number in list is #" + (position + 1));
        } else {
            System.out.println("Contact " + name + " does not exist in contact list");
        }
    }

    private Contact getContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name))
                return contact;
        }

        return null;
    }

    private int getContactPosition(String name) {
        Contact contact;
        for(int i = 0; i < contacts.size(); ++i) {
            contact = contacts.get(i);
            if (contact.getName().equals(name))
                return i;
        }

        return -1;
    }
}
