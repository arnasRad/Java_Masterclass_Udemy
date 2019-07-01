package com.arnasRad.contactApp;

import com.arnasRad.contactApp.data_model.Contact;
import com.arnasRad.contactApp.data_model.ContactData;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DialogController {
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField phoneNumberField;
    @FXML private TextArea notesField;

    public Contact processResults() {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String phoneNumber = phoneNumberField.getText().trim();
        String notes = notesField.getText().trim();

        Contact contact = new Contact(firstName, lastName, phoneNumber, notes);
        ContactData.getInstance().addContact(contact);
        return contact;
    }
}
