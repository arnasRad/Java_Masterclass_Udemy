package com.arnasRad.contactApp.data_model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

// Singleton class
public class ContactData {
    private static ContactData instance = new ContactData();
    private static String filename = "ContactItems.txt";
    private ObservableList<Contact> contacts;

    public static ContactData getInstance() {
        return instance;
    }

    private ContactData() {

    }

    public ObservableList<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }

    public void deleteContact(Contact contact) {
        contacts.remove(contact);
    }

    public void editContact(Contact contact, String firstName, String lastName,
                            String phoneNumber, String notes) {
        contact.setFirstNameCol(firstName);
        contact.setLastNameCol(lastName);
        contact.setPhoneNumberCol(phoneNumber);
        contact.setNotesCol(notes);
    }

    public void loadContacts() throws IOException {
        contacts = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);

        String input;

        try {
            while((input = br.readLine()) != null) {
                String[] itemPieces = input.split("\t");

                addContact(new Contact(
                        getEmptyTextIfBlank(itemPieces[0]),
                        getEmptyTextIfBlank(itemPieces[1]),
                        getEmptyTextIfBlank(itemPieces[2]),
                        getEmptyTextIfBlank(itemPieces[3])));
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    public void storeTodoItems() throws IOException {
        Path path = Paths.get(filename);
        BufferedWriter bw = Files.newBufferedWriter(path);

        try {
            Iterator<Contact> iter = contacts.iterator();
            while(((Iterator) iter).hasNext()) {
                Contact contact = iter.next();

                bw.write(String.format("%s\t%s\t%s\t%s",
                        getNonBlankText(contact.getFirstNameCol()),
                        getNonBlankText(contact.getLastNameCol()),
                        getNonBlankText(contact.getPhoneNumberCol()),
                        getNonBlankText(contact.getNotesCol())));
                bw.newLine();
            }
        } finally {
            if (bw != null) {
                bw.close();
            }
        }
    }

    private String getNonBlankText(String text) {
        if (!text.equals("")) {
            return text;
        } else {
            return "$blank";
        }
    }

    private String getEmptyTextIfBlank(String text) {
        if(!text.equals("$blank")) {
            return text;
        } else {
            return("");
        }
    }
}
