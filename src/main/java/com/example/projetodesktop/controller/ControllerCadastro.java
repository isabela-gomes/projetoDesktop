package com.example.projetodesktop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerCadastro {

    @FXML
    private TextField Tfcadastro;

    @FXML
    private PasswordField Tfsenha;

    @FXML
    private TextField TfsenhaTexto;

    @FXML
    private Button BtnVerSenha;

    @FXML
    private PasswordField Tfconfirmarsenha;

    @FXML
    private TextField TfconfirmarsenhaTexto;

    @FXML
    private Button BtnVerConfirmarSenha;

    @FXML
    private Button BttEntrar;

    @FXML
    private Hyperlink Hplogin;

    private boolean senhaVisivel = false;
    private boolean confirmarSenhaVisivel = false;

    @FXML
    private void handleToggleMostrarSenha(ActionEvent event) {
        senhaVisivel = !senhaVisivel;
        if (senhaVisivel) {
            TfsenhaTexto.setText(Tfsenha.getText());
            TfsenhaTexto.setVisible(true);
            Tfsenha.setVisible(false);
            BtnVerSenha.setText("🙈");
        } else {
            Tfsenha.setText(TfsenhaTexto.getText());
            TfsenhaTexto.setVisible(false);
            Tfsenha.setVisible(true);
            BtnVerSenha.setText("👁");
        }
    }

    @FXML
    private void handleToggleMostrarConfirmarSenha(ActionEvent event) {
        confirmarSenhaVisivel = !confirmarSenhaVisivel;
        if (confirmarSenhaVisivel) {
            TfconfirmarsenhaTexto.setText(Tfconfirmarsenha.getText());
            TfconfirmarsenhaTexto.setVisible(true);
            Tfconfirmarsenha.setVisible(false);
            BtnVerConfirmarSenha.setText("🙈");
        } else {
            Tfconfirmarsenha.setText(TfconfirmarsenhaTexto.getText());
            TfconfirmarsenhaTexto.setVisible(false);
            Tfconfirmarsenha.setVisible(true);
            BtnVerConfirmarSenha.setText("👁");
        }
    }

    private String getSenhaDigitada() {
        return senhaVisivel ? TfsenhaTexto.getText() : Tfsenha.getText();
    }

    private String getConfirmarSenhaDigitada() {
        return confirmarSenhaVisivel ? TfconfirmarsenhaTexto.getText() : Tfconfirmarsenha.getText();
    }

    @FXML
    private void handleCadastrar(ActionEvent event) {
        String usuario = Tfcadastro.getText();
        String senha = getSenhaDigitada();
        String confirmarSenha = getConfirmarSenhaDigitada();

        if (usuario == null || usuario.trim().isEmpty() ||
                senha == null || senha.trim().isEmpty() ||
                confirmarSenha == null || confirmarSenha.trim().isEmpty()) {

            exibirAlerta("Aviso", "Campos Incompletos", "Por favor, preencha todos os campos do cadastro.", Alert.AlertType.WARNING);
            return;
        }

        if (!senha.equals(confirmarSenha)) {
            exibirAlerta("Aviso", "Senhas Incompatíveis", "A senha e a confirmação de senha não coincidem.", Alert.AlertType.WARNING);
            return;
        }

        // Mensagem exatamente no formato que forneceu originalmente:
        exibirAlerta("Sucesso", "Cadastro Realizado", "Usuário " + usuario + " cadastrado com sucesso!", Alert.AlertType.INFORMATION);
    }

    @FXML
    private void handleIrParaLogin(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/projetodesktop/view/login.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            exibirAlerta("Erro", "Erro ao carregar a tela", "Não foi possível abrir a tela de login.", Alert.AlertType.ERROR);
        }
    }

    private void exibirAlerta(String titulo, String cabecalho, String mensagem, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(cabecalho);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}