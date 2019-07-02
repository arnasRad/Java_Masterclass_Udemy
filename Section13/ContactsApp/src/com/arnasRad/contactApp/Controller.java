package com.arnasRad.contactApp;

import com.arnasRad.contactApp.data_model.Contact;
import com.arnasRad.contactApp.data_model.ContactData;
import javafx.application.Platform;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Comparator;
import java.util.Optional;

public class Controller {
    @FXML TableView<Contact> contactsTableView;
    @FXML TableColumn<Contact, String> firstNameCol;
    @FXML TableColumn<Contact, String> lastNameCol;
    @FXML TableColumn<Contact, String> phoneNumberCol;
    @FXML TableColumn<Contact, String> notesCol;

    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private ContextMenu listContextMenu;

    public void initialize() {
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstNameCol"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastNameCol"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumberCol"));
        notesCol.setCellValueFactory(new PropertyValueFactory<>("notesCol"));

//        ObservableList<Contact> tableValues = FXCollections.observableArrayList();

        SortedList<Contact> sortedList = new SortedList<>(
                ContactData.getInstance().getContacts(),
                new Comparator<Contact>() {
                    @Override
                    public int compare(Contact o1, Contact o2) {
                        return o1.getLastNameCol().compareTo(o2.getLastNameCol());
                    }
                });

        contactsTableView.setItems(sortedList);
        contactsTableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        contactsTableView.getSelectionModel().selectFirst();
    }

//    public ObservableList<Contact> getContactValues() {
//        return this.contactsTableView.getItems();
//    }

    @FXML
    public void handleExit() {
        Platform.exit();
    }

    @FXML
    public void showNewItemDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add new Contact");
        dialog.setHeaderText("Use this dialog to create a new Contact");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("contact_dialog.fxml"));
        try{
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch(IOException e) {
            System.out.println("Couldn't load the new contact dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            DialogController controller = fxmlLoader.getController();
            Contact newItem = controller.processNewResults();
            contactsTableView.getSelectionModel().select(newItem);
        }
    }

    @FXML
    public void showEditItemDialog() {
        Contact selectedContact = contactsTableView.getSelectionModel().getSelectedItem();

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Edit the Contact");
        dialog.setHeaderText("Use this dialog to edit the contact");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("contact_dialog.fxml"));

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Coulndn't load the edit contact dialog");
            e.printStackTrace();
            return;
        }
        DialogController controller = fxmlLoader.getController();

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        controller.setFirstNameField(selectedContact.getFirstNameCol());
        controller.setLastNameField(selectedContact.getLastNameCol());
        controller.setPhoneNumberField(selectedContact.getPhoneNumberCol());
        controller.setNotesField(selectedContact.getNotesCol());

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            controller.processEditResults(selectedContact);
            contactsTableView.getSelectionModel().select(selectedContact);
        }
    }

    @FXML
    public void deleteContactItem() {
        Contact selectedItem = contactsTableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            deleteItem(selectedItem);
        }
    }

    @FXML
    public void handleKeyPressed(KeyEvent keyEvent) {
        Contact selectedItem = contactsTableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            if (keyEvent.getCode().equals(KeyCode.DELETE)) {
                deleteItem(selectedItem);
            }
        }
    }

    public void deleteItem(Contact item) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Contact");
        alert.setHeaderText("Delete contact " + item.getFirstNameCol() + " " + item.getLastNameCol());
        alert.setContentText("Are you sure? Press OK to confirm, or cancel to Back out.");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && (result.get() == ButtonType.OK)) {
            ContactData.getInstance().deleteContact(item);
        }
    }
}
