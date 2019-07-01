package com.arnasRad.contactApp;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import com.arnasRad.contactApp.data_model.Contact;

public class Controller {
    @FXML TableView<Contact> contactsTableView;
    @FXML TableColumn<Contact, String> firstNameCol;
    @FXML TableColumn<Contact, String> lastNameCol;
    @FXML TableColumn<Contact, String> phoneNumberCol;
    @FXML TableColumn<Contact, String> notesCol;

    public void initialize() {
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstNameCol"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastNameCol"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumberCol"));
        notesCol.setCellValueFactory(new PropertyValueFactory<>("notesCol"));

        ObservableList<Contact> tableValues = FXCollections.observableArrayList();



        contactsTableView.setItems(tableValues);
    }

    public ObservableList<Contact> getContactValues() {
        return this.contactsTableView.getItems();
    }

    public void addContact(Contact contact) {
        getContactValues().add(contact);
    }

    @FXML
    public void handleExit() {
        Platform.exit();
    }
}
