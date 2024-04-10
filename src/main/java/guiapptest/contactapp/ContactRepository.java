package guiapptest.contactapp;

import javafx.collections.ObservableList;

import java.util.List;

public interface ContactRepository <Contact>{
    void addContact(Contact contact);
    List<Contact> getAllContacts();
    void deleteContact(Contact contact);
}
