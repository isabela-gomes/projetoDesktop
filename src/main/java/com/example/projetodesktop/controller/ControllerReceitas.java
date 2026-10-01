package com.example.projetodesktop.controller;

import com.example.projetodesktop.database.BancoDeDados;
import com.example.projetodesktop.model.Alimentos;
import com.example.projetodesktop.model.Receita;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControllerReceitas {
    @FXML
    private TextField txtReceita;
    @FXML
    private TextField txtAlergicos;
    @FXML
    private TextField txtTabelaNutricional;
    @FXML
    private TextField txtNome;
    @FXML
    private Button btnExcluirReceita;
    @FXML
    private Button btnCadastrarReceita;

    public void ExcluirReceita() {
        txtAlergicos.clear();
        txtTabelaNutricional.clear();
        txtReceita.clear();
    }
    public void RegistrarReceitas() {
        String nome = txtNome.getText();
        String descricao = txtReceita.getText();
        String alergicos = txtAlergicos.getText();
        String tabelaNutricional = txtTabelaNutricional.getText();

        if (nome.length() == 0|| descricao.length() == 0|| alergicos.length() == 0 || tabelaNutricional.length() == 0) {
            exibirAlerta(Alert.AlertType.WARNING, "Aviso", "Por favor,preencha todos os campos para continuar.");
            return;
        }
        Receita receita = new Receita(nome, descricao, alergicos, tabelaNutricional);
        BancoDeDados.receitas.add(receita);
        exibirAlerta(Alert.AlertType.INFORMATION, "Cadastro Completo",
                "A receita " + nome + " foi adicionada");
        ExcluirReceita();
    }
    private void exibirAlerta(Alert.AlertType tipo, String titulo, String mensagem) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
}
