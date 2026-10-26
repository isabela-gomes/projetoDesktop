module com.example.projetodesktop {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.example.projetodesktop.controller to javafx.fxml;
    exports com.example.projetodesktop.controller;

    opens com.example.projetodesktop.model to javafx.fxml;
    exports com.example.projetodesktop.model;

    opens com.example.projetodesktop to javafx.fxml;
    exports com.example.projetodesktop;

    opens com.example.projetodesktop.controller to javafx.fxml;
    exports com.example.projetodesktop.controller;
}