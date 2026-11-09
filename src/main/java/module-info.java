module com.example.projetodesktop {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.example.projetodesktop to javafx.fxml;
    opens com.example.projetodesktop.controller to javafx.fxml;
    opens com.example.projetodesktop.model to javafx.base, javafx.fxml;

    exports com.example.projetodesktop;
    exports com.example.projetodesktop.controller;
    exports com.example.projetodesktop.model;
}
