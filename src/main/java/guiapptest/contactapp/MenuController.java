package guiapptest.contactapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController {
    @FXML
    private BorderPane borderPane;
    @FXML
    private Button contactListButton;

    public void openContactList() throws IOException {
        HBox view = FXMLLoader.load(getClass().getResource("contactlist.fxml"));
        borderPane.setCenter(view);
    }

    public void openAddContact() throws IOException{
        VBox view = FXMLLoader.load(getClass().getResource("addcontact.fxml"));
        borderPane.setCenter(view);
    }

}