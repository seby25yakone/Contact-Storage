package guiapptest.contactapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddContactController {
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

}
