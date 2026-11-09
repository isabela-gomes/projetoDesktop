package com.example.projetodesktop.controller;

import com.example.projetodesktop.model.GerenciadorDados;
import com.example.projetodesktop.model.SessaoUsuario;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

public class ControllerLogin {
    @FXML private TextField TfLogin, TfsenhaTexto;
    @FXML private PasswordField Tfsenha;
    @FXML private Button BtnVerSenha;
    private boolean senhaVisivel;
    @FXML private void handleToggleMostrarSenha(ActionEvent e) {
        senhaVisivel=!senhaVisivel;
        if (senhaVisivel) { TfsenhaTexto.setText(Tfsenha.getText()); TfsenhaTexto.setVisible(true); TfsenhaTexto.setManaged(true); Tfsenha.setVisible(false); Tfsenha.setManaged(false); BtnVerSenha.setText("🙈"); }
        else { Tfsenha.setText(TfsenhaTexto.getText()); Tfsenha.setVisible(true); Tfsenha.setManaged(true); TfsenhaTexto.setVisible(false); TfsenhaTexto.setManaged(false); BtnVerSenha.setText("👁"); }
    }
    @FXML private void handleEntrar(ActionEvent event) {
        String login=TfLogin.getText()==null?"":TfLogin.getText().trim();
        String senha=senhaVisivel?TfsenhaTexto.getText():Tfsenha.getText();
        if (login.isEmpty() || senha==null || senha.isBlank()) { alerta(Alert.AlertType.WARNING,"Preenchimento obrigatório","Informe login e senha."); return; }
        GerenciadorDados.UsuarioModel gerente=GerenciadorDados.buscarGerente(login);
        if (gerente==null || !gerente.getSenha().equals(senha)) { alerta(Alert.AlertType.ERROR,"Acesso não autorizado","Login ou senha inválidos."); return; }
        SessaoUsuario.getInstancia().setUsuarioLogado(login);
        Navegacao.abrir(event,"menu.fxml");
    }
    @FXML private void handleIrParaCadastro(ActionEvent event) { Navegacao.abrir(event,"Cadastro.fxml"); }
    private void alerta(Alert.AlertType tipo,String titulo,String mensagem){ Alert a=new Alert(tipo); a.setTitle(titulo); a.setHeaderText(null); a.setContentText(mensagem); a.showAndWait(); }
}
