package com.example.projetodesktop.controller;

import com.example.projetodesktop.model.SessaoUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerMenu {

    @FXML private Label lblBoasVindas;

    @FXML
    public void initialize() {
        String usuario = SessaoUsuario.getInstancia().getUsuarioLogado();
        if (usuario != null && lblBoasVindas != null) {
            lblBoasVindas.setText("Olá, " + usuario + "!");
        }
    }

    private void navegarPara(ActionEvent event, String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAbrirGerenciarUsuarios(ActionEvent event) {
        navegarPara(event, "/com/example/projetodesktop/view/RegistroLogins.fxml");
    }

    @FXML
    private void handleAbrirHelpCenter(ActionEvent event) {
        navegarPara(event, "/com/example/projetodesktop/view/HelpCenter.fxml");
    }

    @FXML
    private void handleAbrirRelatorios(ActionEvent event) {
        navegarPara(event, "/com/example/projetodesktop/view/Relatorios.fxml");
    }

    @FXML
    private void handleSair(ActionEvent event) {
        SessaoUsuario.getInstancia().encerrarSessao();
        navegarPara(event, "/com/example/projetodesktop/view/login.fxml");
    }
}