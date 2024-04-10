package guiapptest.contactapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML
    private BorderPane borderPane;
    @FXML
    private Button contactListButton;
    private ContactRepository repository;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        repository = new MemoryContactRepository();
    }
    public void openContactList() throws IOException {
        FXMLLoader listLoader = new FXMLLoader(getClass().getResource("contactlist.fxml"));
        listLoader.setControllerFactory(controllerClass -> new ContactListController(repository));
        HBox view = listLoader.load();
        ContactListController contactListController = new ContactListController(repository);
        borderPane.setCenter(view);
    }

    public void openAddContact() throws IOException{
        FXMLLoader addLoader= new FXMLLoader(getClass().getResource("addcontact.fxml"));
        addLoader.setControllerFactory(controllerClass -> new AddContactController(repository));
        VBox view = addLoader.load();
        AddContactController addContactController = new AddContactController(repository);
        borderPane.setCenter(view);
    }


}