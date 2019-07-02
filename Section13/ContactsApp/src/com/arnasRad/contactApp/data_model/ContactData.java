package com.arnasRad.contactApp.data_model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
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

                String firstName = itemPieces[0];
                String lastName = itemPieces[1];
                String phoneNumber = itemPieces[2];
                String notes = itemPieces[3];

                addContact(new Contact(firstName, lastName, phoneNumber, notes));
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
                        contact.getFirstNameCol(),
                        contact.getLastNameCol(),
                        contact.getPhoneNumberCol(),
                        contact.getNotesCol()));
                bw.newLine();
            }
        } finally {
            if (bw != null) {
                bw.close();
            }
        }
    }
}
