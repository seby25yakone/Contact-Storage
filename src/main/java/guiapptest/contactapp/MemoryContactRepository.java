package guiapptest.contactapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class MemoryContactRepository implements ContactRepository<Contact>{
    private List<Contact> contacts = new ArrayList<>();
    public void addContact(Contact contact){
        ContactDataSource.save(contact);
        contacts.add(contact);
    }
    public List<Contact> getAllContacts(){
        contacts = ContactDataSource.findAll();
        return contacts;
    }
    public void deleteContact(Contact contact){
        ContactDataSource.deleteContact(contact);
        contacts.remove(contact);
    }
}
