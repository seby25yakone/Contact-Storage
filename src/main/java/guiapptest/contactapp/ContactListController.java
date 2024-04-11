package guiapptest.contactapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ContactListController implements Initializable {
    private ContactRepository contactRepository;
    @FXML
    private HBox hBox;
    @FXML
    private ListView<Contact> contactListView;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private Button deleteContact;

    private Contact currentContact;

    public ContactListController(){}

    public ContactListController(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Contact> contacts = contactRepository.getAllContacts();
        contactListView.setItems(FXCollections.observableList(contacts));
        contactListView.refresh();
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
    public void deleteContact(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete contact");
        alert.setHeaderText("Are you sure you want to delete this contact?");
        alert.setContentText("This action cannot be undone!");
        if(contactListView.getSelectionModel().getSelectedItem()!=null) {
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {

                contactRepository.deleteContact(contactListView.getSelectionModel().getSelectedItem());
                contactListView.refresh();
                nameTextField.clear();
                phoneTextField.clear();
                emailTextField.clear();
            } else {
                alert.close();
            }
        }
    }

    protected void addListContact(Contact c){
        contactRepository.addContact(c);
    }

    public void setAquaTheme(){
        hBox.getStylesheets().clear();
        hBox.getStylesheets().add(getClass().getResource("/styles/AquaTheme.css").toExternalForm());
    }

}
