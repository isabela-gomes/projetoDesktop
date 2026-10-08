package com.example.projetodesktop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerNavBar {

public void irParaInicio(ActionEvent event) throws IOException {
trocarTela(event, "menu.fxml");
}
    public void irParaAlimentos(ActionEvent event) throws IOException {
        trocarTela(event, "AlimentoCAdastro.fxml");
    }
    public void irParaPerguntas(ActionEvent event) throws IOException {
        trocarTela(event, "RegistroPergunta.fxml");
    }

    private void trocarTela(ActionEvent event, String arquivo) throws IOException {

        Parent root = FXMLLoader.load(
                getClass().getResource("/com/example/projetoDesktop/view/" + arquivo)
        );
        System.out.println(arquivo);
        Stage stage = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }
}
