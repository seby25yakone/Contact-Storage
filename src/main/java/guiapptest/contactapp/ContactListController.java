package guiapptest.contactapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.net.URL;
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
                nameTextField.setText(currentContact.getName());
                phoneTextField.setText(currentContact.getPhoneNumber());
                emailTextField.setText(currentContact.getEmail());
            }
        });
    }

}
