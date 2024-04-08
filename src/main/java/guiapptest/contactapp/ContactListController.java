package guiapptest.contactapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class ContactListController implements Initializable {
    @FXML
    private ListView<Contact> contactListView;
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
    }
}
