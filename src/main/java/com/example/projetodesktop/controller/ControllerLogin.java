package com.example.projetodesktop.controller;

import com.example.projetodesktop.model.GerenciadorDados;
import com.example.projetodesktop.model.SessaoUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerLogin {

    @FXML private TextField TfLogin;
    @FXML private PasswordField Tfsenha;
    @FXML private TextField TfsenhaTexto;
    @FXML private Button BtnVerSenha;

    private boolean senhaVisivel = false;

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

    private String getSenhaDigitada() {
        return senhaVisivel ? TfsenhaTexto.getText() : Tfsenha.getText();
    }

    @FXML
    private void handleEntrar(ActionEvent event) {
        String login = TfLogin.getText();
        String senha = getSenhaDigitada();

        if (login == null || login.trim().isEmpty() || senha == null || senha.trim().isEmpty()) {
            exibirAlerta("Aviso", "Preenchimento Obrigatório", "Por favor, preencha o login e a senha para entrar.", Alert.AlertType.WARNING);
            return;
        }

        if (!GerenciadorDados.gerenteExiste(login)) {
            exibirAlerta("Erro de Acesso", "Usuário Inexistente", "Não existe nenhuma conta de gerente com esse nome de login.", Alert.AlertType.ERROR);
            return;
        }

        GerenciadorDados.UsuarioModel gerente = GerenciadorDados.buscarGerente(login);
        if (!gerente.getSenha().equals(senha)) {
            exibirAlerta("Erro de Acesso", "Senha Inválida", "A senha digitada está incorreta. Verifique e tente novamente.", Alert.AlertType.ERROR);
            return;
        }

        SessaoUsuario.getInstancia().setUsuarioLogado(login);
        exibirAlerta("Sucesso", "Login Realizado", "Bem-vindo(a), " + login + "!", Alert.AlertType.INFORMATION);

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/projetodesktop/view/menu.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleIrParaCadastro(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/projetodesktop/view/cadastro.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
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