package com.example.projetodesktop.controller;

import com.example.projetodesktop.model.SessaoUsuario;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class ControllerMenu {
    @FXML private Label lblBoasVindas;
    @FXML public void initialize(){String usuario=SessaoUsuario.getInstancia().getUsuarioLogado(); if(lblBoasVindas!=null) lblBoasVindas.setText("Olá, "+(usuario==null?"Gerente":usuario)+"!");}
    @FXML private void abrirQuiz(ActionEvent e){Navegacao.abrir(e,"RegistrarQuiz.fxml");}
    @FXML private void abrirReceitas(ActionEvent e){Navegacao.abrir(e,"CadastroReceitas.fxml");}
    @FXML private void abrirLembretes(ActionEvent e){Navegacao.abrir(e,"Lembretecadastro.fxml");}
    @FXML private void abrirClientes(ActionEvent e){Navegacao.abrir(e,"ListaDeUsuarios.fxml");}
    @FXML private void abrirLogins(ActionEvent e){Navegacao.abrir(e,"RegistroLogins.fxml");}
    @FXML private void abrirDenuncias(ActionEvent e){Navegacao.abrir(e,"HelpCenter.fxml");}
    @FXML private void abrirRelatorios(ActionEvent e){Navegacao.abrir(e,"Relatorios.fxml");}
    @FXML private void sair(ActionEvent e){SessaoUsuario.getInstancia().encerrarSessao();Navegacao.abrir(e,"login.fxml");}
}
