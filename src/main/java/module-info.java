module com.example.projetodesktop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projetodesktop to javafx.fxml;
    exports com.example.projetodesktop;
}