package guiapptest.contactapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.FileNotFoundException;
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
    private MenuItem defaultLight;
    @FXML
    private MenuItem darkTheme;
    @FXML
    private MenuItem aquaTheme;
    @FXML
    private MenuItem galaxyTheme;
    @FXML
    private MenuItem deepOcean;
    private ContactRepository repository;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            repository = new MemoryContactRepository();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
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

    public void setDefaultLightTheme(ActionEvent event) throws IOException {
        borderPane.getStylesheets().clear();
        FXMLLoader listLoader = new FXMLLoader(getClass().getResource("contactlist.fxml"));
        listLoader.setControllerFactory(controllerClass -> new ContactListController(repository));
        Parent root1 = listLoader.load();
        ContactListController listView = listLoader.getController();
        listView.setDefaultLightTheme();
        FXMLLoader addLoader = new FXMLLoader(getClass().getResource("addcontact.fxml"));
        addLoader.setControllerFactory(controllerClass -> new AddContactController(repository));
        Parent root2 = addLoader.load();
        AddContactController addView = addLoader.getController();
        addView.setDefaultLightTheme();

    }

    public void setAquaTheme(ActionEvent event) throws IOException {
        borderPane.getStylesheets().clear();
        borderPane.getStylesheets().add(getClass().getResource("/styles/AquaTheme.css").toExternalForm());
        FXMLLoader listLoader = new FXMLLoader(getClass().getResource("contactlist.fxml"));
        listLoader.setControllerFactory(controllerClass -> new ContactListController(repository));
        Parent root1 = listLoader.load();
        ContactListController listView = listLoader.getController();
        listView.setAquaTheme();
        FXMLLoader addLoader = new FXMLLoader(getClass().getResource("addcontact.fxml"));
        addLoader.setControllerFactory(controllerClass -> new AddContactController(repository));
        Parent root2 = addLoader.load();
        AddContactController addView = addLoader.getController();
        addView.setAquaTheme();

    }

    public void setGalaxyTheme(ActionEvent event) throws IOException{
        borderPane.getStylesheets().clear();
        borderPane.getStylesheets().add(getClass().getResource("/styles/GalaxyTheme.css").toExternalForm());
        FXMLLoader listLoader = new FXMLLoader(getClass().getResource("contactlist.fxml"));
        listLoader.setControllerFactory(controllerClass -> new ContactListController(repository));
        Parent root1 = listLoader.load();
        ContactListController listView = listLoader.getController();
        listView.setGalaxyTheme();
        FXMLLoader addLoader = new FXMLLoader(getClass().getResource("addcontact.fxml"));
        addLoader.setControllerFactory(controllerClass -> new AddContactController(repository));
        Parent root2 = addLoader.load();
        AddContactController addView = addLoader.getController();
        addView.setGalaxyTheme();
    }

    public void setDarkTheme(ActionEvent event) throws IOException {
        borderPane.getStylesheets().clear();
        borderPane.getStylesheets().add(getClass().getResource("/styles/DarkTheme.css").toExternalForm());
        FXMLLoader listLoader = new FXMLLoader(getClass().getResource("contactlist.fxml"));
        listLoader.setControllerFactory(controllerClass -> new ContactListController(repository));
        Parent root1 = listLoader.load();
        ContactListController listView = listLoader.getController();
        listView.setDarkTheme();
        FXMLLoader addLoader = new FXMLLoader(getClass().getResource("addcontact.fxml"));
        addLoader.setControllerFactory(controllerClass -> new AddContactController(repository));
        Parent root2 = addLoader.load();
        AddContactController addView = addLoader.getController();
        addView.setDarkTheme();
    }

    public void setDeepOceanTheme(ActionEvent event) throws IOException{
        borderPane.getStylesheets().clear();
        borderPane.getStylesheets().add(getClass().getResource("/styles/DeepOceanTheme.css").toExternalForm());
        FXMLLoader listLoader = new FXMLLoader(getClass().getResource("contactlist.fxml"));
        listLoader.setControllerFactory(controllerClass -> new ContactListController(repository));
        Parent root1 = listLoader.load();
        ContactListController listView = listLoader.getController();
        listView.setDeepOceanTheme();
        FXMLLoader addLoader = new FXMLLoader(getClass().getResource("addcontact.fxml"));
        addLoader.setControllerFactory(controllerClass -> new AddContactController(repository));
        Parent root2 = addLoader.load();
        AddContactController addView = addLoader.getController();
        addView.setDeepOceanTheme();
    }

}