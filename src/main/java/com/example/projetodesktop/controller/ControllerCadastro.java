package com.example.projetodesktop.controller;

import com.example.projetodesktop.model.GerenciadorDados;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class ControllerCadastro {
    @FXML private TextField Tfcadastro, TfsenhaTexto, TfconfirmarsenhaTexto;
    @FXML private PasswordField Tfsenha, Tfconfirmarsenha;
    @FXML private Button BtnVerSenha, BtnVerConfirmarSenha;
    private boolean senhaVisivel, confirmarSenhaVisivel;
    @FXML private void handleToggleMostrarSenha(ActionEvent e){ senhaVisivel=!senhaVisivel; alternar(Tfsenha,TfsenhaTexto,BtnVerSenha,senhaVisivel); }
    @FXML private void handleToggleMostrarConfirmarSenha(ActionEvent e){ confirmarSenhaVisivel=!confirmarSenhaVisivel; alternar(Tfconfirmarsenha,TfconfirmarsenhaTexto,BtnVerConfirmarSenha,confirmarSenhaVisivel); }
    private void alternar(PasswordField oculto,TextField visivel,Button botao,boolean mostrar){ if(mostrar){visivel.setText(oculto.getText());visivel.setVisible(true);visivel.setManaged(true);oculto.setVisible(false);oculto.setManaged(false);botao.setText("🙈");}else{oculto.setText(visivel.getText());oculto.setVisible(true);oculto.setManaged(true);visivel.setVisible(false);visivel.setManaged(false);botao.setText("👁");} }
    @FXML private void handleCadastrar(ActionEvent e){
        String usuario=Tfcadastro.getText()==null?"":Tfcadastro.getText().trim();
        String senha=senhaVisivel?TfsenhaTexto.getText():Tfsenha.getText();
        String confirmar=confirmarSenhaVisivel?TfconfirmarsenhaTexto.getText():Tfconfirmarsenha.getText();
        if(usuario.isEmpty()||senha==null||senha.isBlank()||confirmar==null||confirmar.isBlank()){alerta(Alert.AlertType.WARNING,"Campos incompletos","Preencha todos os campos.");return;}
        if(GerenciadorDados.gerenteExiste(usuario)){alerta(Alert.AlertType.WARNING,"Usuário já existe","Escolha outro login.");return;}
        if(!senha.equals(confirmar)){alerta(Alert.AlertType.WARNING,"Senhas incompatíveis","A senha e a confirmação não coincidem.");return;}
        GerenciadorDados.adicionarGerente(usuario,senha); alerta(Alert.AlertType.INFORMATION,"Cadastro realizado","Conta criada. Você já pode entrar."); Navegacao.abrir(e,"login.fxml");
    }
    @FXML private void handleIrParaLogin(ActionEvent e){Navegacao.abrir(e,"login.fxml");}
    private void alerta(Alert.AlertType t,String h,String m){Alert a=new Alert(t);a.setTitle(h);a.setHeaderText(null);a.setContentText(m);a.showAndWait();}
}
