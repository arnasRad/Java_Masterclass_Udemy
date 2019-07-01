package sample.data_model;

import javafx.beans.property.SimpleStringProperty;

public class Contact {
    private SimpleStringProperty firstNameCol;
    private SimpleStringProperty lastNameCol;
    private SimpleStringProperty phoneNumberCol;
    private SimpleStringProperty notesCol;

    public Contact(String firstName, String lastName, String phoneNumber, String notes) {
        this.firstNameCol = new SimpleStringProperty(firstName);
        this.lastNameCol = new SimpleStringProperty(lastName);
        this.phoneNumberCol = new SimpleStringProperty(phoneNumber);
        this.notesCol = new SimpleStringProperty(notes);
    }

    public String getFirstNameCol() {
        return firstNameCol.get();
    }

    public SimpleStringProperty firstNameColProperty() {
        return firstNameCol;
    }

    public void setFirstNameCol(String firstNameCol) {
        this.firstNameCol.set(firstNameCol);
    }

    public String getLastNameCol() {
        return lastNameCol.get();
    }

    public SimpleStringProperty lastNameColProperty() {
        return lastNameCol;
    }

    public void setLastNameCol(String lastNameCol) {
        this.lastNameCol.set(lastNameCol);
    }

    public String getPhoneNumberCol() {
        return phoneNumberCol.get();
    }

    public SimpleStringProperty phoneNumberColProperty() {
        return phoneNumberCol;
    }

    public void setPhoneNumberCol(String phoneNumberCol) {
        this.phoneNumberCol.set(phoneNumberCol);
    }

    public String getNotesCol() {
        return notesCol.get();
    }

    public SimpleStringProperty notesColProperty() {
        return notesCol;
    }

    public void setNotesCol(String notesCol) {
        this.notesCol.set(notesCol);
    }
}
