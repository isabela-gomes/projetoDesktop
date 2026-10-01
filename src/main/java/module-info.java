module com.example.projetodesktop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projetodesktop to javafx.fxml;
    exports com.example.projetodesktop;

    opens com.example.projetodesktop.controller to javafx.fxml;
    exports com.example.projetodesktop.controller;
}