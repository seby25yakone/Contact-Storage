module guiapptest.contactapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;

    opens guiapptest.contactapp to javafx.fxml;
    exports guiapptest.contactapp;
}