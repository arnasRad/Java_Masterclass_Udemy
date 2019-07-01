package com.arnasRad.contactApp;

import com.arnasRad.contactApp.data_model.ContactData;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import com.arnasRad.contactApp.data_model.Contact;
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

    public void initialize() {
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstNameCol"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastNameCol"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumberCol"));
        notesCol.setCellValueFactory(new PropertyValueFactory<>("notesCol"));

        ObservableList<Contact> tableValues = FXCollections.observableArrayList();

        SortedList<Contact> sortedList = new SortedList<>(
                ContactData.getInstance().getContacts(),
                new Comparator<Contact>() {
                    @Override
                    public int compare(Contact o1, Contact o2) {
                        return o1.getLastNameCol().compareTo(o2.getLastNameCol());
                    }
                });

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

    @FXML
    public void showNewItemDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add new Contact");
        dialog.setHeaderText("Use this dialog to create a new Contact");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("new_contact_dialog.fxml"));
        try{
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch(IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            DialogController controller = fxmlLoader.getController();
            Contact newItem = controller.processResults();
//            todoListView.getItems().setAll(TodoData.getInstance().getTodoItems());
            contactsTableView.getSelectionModel().select(newItem);
        }
    }
}
