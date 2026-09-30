package com.example.projetodesktop.controller;

import com.example.projetodesktop.database.BancoDeDados;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.example.projetodesktop.model.Alimentos;

public class ControllerCadastroAlimento {

    @FXML
private TextField txnomeali;

    @FXML
    private TextField txcategoriaali;

    @FXML
    private TextField txcaloriaali;

    @FXML
    private Button btncadastrar;

    @FXML
    private Button btnlimpar;


    public void limpar() {
    txnomeali.clear();
    txcategoriaali.clear();
    txcaloriaali.clear();
    }
    public void CadastrarAlimento() {
 String nome = txnomeali.getText();
 String categoria = txcategoriaali.getText();
 double calorias = txcaloriaali.getHeight();

        if (nome.length()== 0|| categoria.length() == 0 || txcaloriaali == null) {
            exibirAlerta(Alert.AlertType.WARNING, "Aviso", "Por favor,preencha todos os campos para continuar.");
            return;
 }
Alimentos alimentos = new Alimentos(nome, categoria, calorias);
        BancoDeDados.alimentos.add(alimentos);
        exibirAlerta(Alert.AlertType.INFORMATION, "Cadastro Completo",
                "Alimento " + nome + " foi adcionado");
        limpar();
    }
    private void exibirAlerta(Alert.AlertType tipo, String titulo, String mensagem) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
    }

