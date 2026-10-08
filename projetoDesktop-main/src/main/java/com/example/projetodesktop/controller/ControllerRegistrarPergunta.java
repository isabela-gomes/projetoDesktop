package com.example.projetodesktop.controller;

import com.example.projetodesktop.database.BancoDeDados;
import com.example.projetodesktop.model.Alimentos;
import com.example.projetodesktop.model.Pergunta;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControllerRegistrarPergunta {

    @FXML
    private TextField txtitulopergunta;

    @FXML
    private TextField txdescricaopergunta;

    @FXML
    private Button btnregistrar;

    @FXML
    private Button btncancelar;
    @FXML
    private Button btnvoltar


    public void limpar() {
        txtitulopergunta.clear();
        txdescricaopergunta.clear();
    }

    public void RegistrarPergunta() {
        String titulo = txtitulopergunta.getText();
        String descricao = txdescricaopergunta.getText();

        if (titulo.length()== 0|| descricao.length() == 0){
            exibirAlerta(Alert.AlertType.WARNING, "Aviso", "Por favor,preencha todos os campos para continuar.");
            return;
        }
        Pergunta perguntas = new Pergunta(titulo, descricao);
        BancoDeDados.perguntas.add(perguntas);
        exibirAlerta(Alert.AlertType.INFORMATION, "Cadastro Completo",
                "O cadastro da pergunta diaria foi completo");
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
