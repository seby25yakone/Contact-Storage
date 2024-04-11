package guiapptest.contactapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
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
    private Button createContactButton;
    @FXML
    private Button contactListButton;
    @FXML
    private MenuButton themeSelector;
    @FXML
    private MenuItem aquaTheme;
    @FXML
    private MenuItem galaxyTheme;
    private ContactRepository repository;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        repository = new MemoryContactRepository();
    }
    public void openContactList(ActionEvent event) throws IOException {
        FXMLLoader listLoader = new FXMLLoader(getClass().getResource("contactlist.fxml"));
        listLoader.setControllerFactory(controllerClass -> new ContactListController(repository));
        HBox view = listLoader.load();
        ContactListController contactListController = new ContactListController(repository);
        borderPane.setCenter(view);
    }

    public void openAddContact(ActionEvent event) throws IOException{
        FXMLLoader addLoader= new FXMLLoader(getClass().getResource("addcontact.fxml"));
        addLoader.setControllerFactory(controllerClass -> new AddContactController(repository));
        VBox view = addLoader.load();
        AddContactController addContactController = new AddContactController(repository);
        borderPane.setCenter(view);
    }

    public void setAquaTheme(ActionEvent event) throws IOException {
        borderPane.getStylesheets().clear();
        borderPane.getStylesheets().add(getClass().getResource("/styles/AquaTheme.css").toExternalForm());
        FXMLLoader listLoader = new FXMLLoader(getClass().getResource("contactlist.fxml"));
        listLoader.setControllerFactory(controllerClass -> new ContactListController(repository));
        HBox listView = listLoader.load();
        listView.getStylesheets().clear();
        listView.getStylesheets().add(getClass().getResource("/styles/AquaTheme.css").toExternalForm());
        FXMLLoader addLoader = new FXMLLoader(getClass().getResource("addcontact.fxml"));
        addLoader.setControllerFactory(controllerClass -> new AddContactController(repository));
        VBox addView = addLoader.load();
        addView.getStylesheets().clear();
        addView.getStylesheets().add(getClass().getResource("/styles/AquaTheme.css").toExternalForm());
    }

    public void setGalaxyTheme(ActionEvent event) throws IOException{
        borderPane.getStylesheets().clear();
        borderPane.getStylesheets().add(getClass().getResource("/styles/GalaxyTheme.css").toExternalForm());
        FXMLLoader listLoader = new FXMLLoader(getClass().getResource("contactlist.fxml"));
        listLoader.setControllerFactory(controllerClass -> new ContactListController(repository));
        HBox listView = listLoader.load();
        listView.getStylesheets().clear();
        listView.getStylesheets().add(getClass().getResource("/styles/GalaxyTheme.css").toExternalForm());
        FXMLLoader addLoader = new FXMLLoader(getClass().getResource("addcontact.fxml"));
        addLoader.setControllerFactory(controllerClass -> new AddContactController(repository));
        VBox addView = addLoader.load();
        addView.getStylesheets().clear();
        addView.getStylesheets().add(getClass().getResource("/styles/GalaxyTheme.css").toExternalForm());
    }


}