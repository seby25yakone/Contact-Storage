package guiapptest.contactapp;

import javafx.scene.control.ListCell;

public class ContactCellFactory extends ListCell<Contact> {
    public ContactCellFactory(){ }
    @Override
    protected void updateItem(Contact item, boolean empty){
        super.updateItem(item, empty);
        setText(item == null ? "" : item.getName());
    }
}
