module com.example.projetodesktop {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.projetodesktop.controller to javafx.fxml;

    // ADICIONE ESTA LINHA ABAIXO:
    opens com.example.projetodesktop.model to javafx.base, javafx.fxml;

    exports com.example.projetodesktop;
}
