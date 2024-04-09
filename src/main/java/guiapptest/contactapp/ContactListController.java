package guiapptest.contactapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ContactListController implements Initializable {
    @FXML
    private ListView<Contact> contactListView;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private TextField emailTextField;

    private Contact currentContact;

    Contact c1 = new Contact("Tudor", "292839","tudi23@gmail.com");
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        contactListView.getItems().add(c1);
        contactListView.setCellFactory(new Callback<ListView<Contact>, ListCell<Contact>>() {
            @Override
            public ListCell<Contact> call(ListView<Contact> contactListView) {
                return new ContactCellFactory();
            }
        });
        contactListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Contact>() {
            @Override
            public void changed(ObservableValue<? extends Contact> observableValue, Contact contact, Contact t1) {
                currentContact = contactListView.getSelectionModel().getSelectedItem();
                if(currentContact!=null){
                    nameTextField.setText(currentContact.getName());
                    phoneTextField.setText(currentContact.getPhoneNumber());
                    emailTextField.setText(currentContact.getEmail());
                }

            }
        });
    }
    public void deleteContact(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete contact");
        alert.setHeaderText("Are you sure you want to delete this contact?");
        alert.setContentText("This action cannot be undone!");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            contactListView.getItems().remove(contactListView.getSelectionModel().getSelectedItem());
            nameTextField.clear();
            phoneTextField.clear();
            emailTextField.clear();
        } else {
            alert.close();
        }
    }
}
