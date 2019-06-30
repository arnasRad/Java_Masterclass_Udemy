public class Contact {
    public static int NAME_LENGTH = 20;
    public static int PHONE_NUMBER_LENGTH = 10;
    String name;
    String phoneNumber;

    public Contact(String name, String phoneNumber) {
        setName(name);
        setPhoneNumber(phoneNumber);
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private void setName(String name) {
        int nameLength = name.length();

        if (nameLength > 0 && nameLength <= NAME_LENGTH)
            this.name = name;
        else
            System.out.println("Name length must be in range [1,20]" +
                    "Input name length: " + nameLength);
    }

    private void setPhoneNumber(String phoneNumber) {
        int phoneNumberLength = phoneNumber.length();
        if (phoneNumberLength > 0 && phoneNumberLength <= PHONE_NUMBER_LENGTH)
            this.phoneNumber = phoneNumber;
        else
            System.out.println("Phone number length must be in range [1,20]. " +
                    "Input number length: " + phoneNumberLength);
    }

    public void setNewContactInfo(String name, String phoneNumber) {
        setName(name);
        setPhoneNumber(phoneNumber);
    }

    public void printContactInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Phone number: " + this.phoneNumber);
    }
}
