module com.example.deanssystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.deanssystem to javafx.fxml;
    exports com.example.deanssystem;
    exports com.example.deanssystem.controllers;
    opens com.example.deanssystem.controllers to javafx.fxml;
}