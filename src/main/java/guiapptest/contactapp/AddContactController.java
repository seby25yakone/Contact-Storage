package guiapptest.contactapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class AddContactController {
    @FXML
    private VBox vBox;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private Label savedMessage;
    @FXML
    private Button saveButton;

    private ContactRepository contactRepository;

    public AddContactController(){}
    public AddContactController(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }

    @FXML
    public void saveContact(ActionEvent event){
        if(nameTextField.getText().isBlank() || phoneTextField.getText().isBlank()){
            savedMessage.setText("Contact must contain at least a name and phone number!");
        } else {
            contactRepository.addContact(new Contact(nameTextField.getText(), phoneTextField.getText(), emailTextField.getText()));
            savedMessage.setText("Contact saved!");
            nameTextField.clear();
            phoneTextField.clear();
            emailTextField.clear();
        }
    }

    public void setAquaTheme(){
        vBox.getStylesheets().clear();
        vBox.getStylesheets().add(getClass().getResource("/styles/AquaTheme.css").toExternalForm());
    }

    public void setGalaxyTheme(){
        vBox.getStylesheets().clear();
        vBox.getStylesheets().add(getClass().getResource("/styles/GalaxyTheme.css").toExternalForm());
    }

    public void setDefaultLightTheme()
    {
        vBox.getStylesheets().clear();
    }

    public void setDarkTheme(){
        vBox.getStylesheets().clear();
        vBox.getStylesheets().add(getClass().getResource("/styles/DarkTheme.css").toExternalForm());
    }

    public void setDeepOceanTheme(){
        vBox.getStylesheets().clear();
        vBox.getStylesheets().add(getClass().getResource("/styles/DeepOceanTheme.css").toExternalForm());
    }

}
