package com.example.projetodesktop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public final class Navegacao {
    private Navegacao() { }

    public static void abrir(ActionEvent event, String arquivo) {
        try {
            Parent root = FXMLLoader.load(Navegacao.class.getResource("/com/example/projetodesktop/view/" + arquivo));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException | RuntimeException e) {
            javafx.scene.control.Alert alerta = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
            alerta.setTitle("Erro de navegação");
            alerta.setHeaderText("Não foi possível abrir a tela");
            alerta.setContentText("Verifique o arquivo " + arquivo + ": " + e.getMessage());
            alerta.showAndWait();
        }
    }
}
