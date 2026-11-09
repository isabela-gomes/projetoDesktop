package com.example.projetodesktop.controller;

import javafx.event.ActionEvent;

public class ControllerNavBar {
    public void irParaInicio(ActionEvent e){Navegacao.abrir(e,"menu.fxml");}
    public void irParaListarUsuario(ActionEvent e){Navegacao.abrir(e,"ListaDeUsuarios.fxml");}
    public void irParaLembretes(ActionEvent e){Navegacao.abrir(e,"Lembretecadastro.fxml");}
}
