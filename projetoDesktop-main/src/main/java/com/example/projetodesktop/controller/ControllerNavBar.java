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
    public void irParaListarUsuario(ActionEvent event) throws IOException {
        trocarTela(event, "ListaDeUsuarios.fxml");
    }
    public void irParaPerguntas(ActionEvent event) throws IOException {
        trocarTela(event, "RegistroPergunta.fxml");
    }
    public void irParaLembretes(ActionEvent event) throws IOException {
        trocarTela(event, "Lembretecadastro.fxml");
    }

    private void trocarTela(ActionEvent event, String arquivo) throws IOException {

        Parent root = FXMLLoader.load(
                getClass().getResource("/com/example/projetodesktop/view/" + arquivo)
        );
        System.out.println(arquivo);
        Stage stage = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }
}
