package com.example.projetodesktop.controller;

import com.example.projetodesktop.database.BancoDeDados;
import com.example.projetodesktop.model.Lembrete;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class ControllerRegistroLembrete {
    @FXML
private TextField txtitulo;
    @FXML
    private TextField txdescricao;
    @FXML
    private ComboBox<String> combohoras;


    @FXML
    public void initialize() {
        ArrayList<String> alternativas = new ArrayList<>();
        alternativas.add("00:00");
        alternativas.add("01:00");
        alternativas.add("02:00");
        alternativas.add("03:00");
        alternativas.add("04:00");
        alternativas.add("05:00");
        alternativas.add("06:00");
        alternativas.add("07:00");
        alternativas.add("08:00");
        alternativas.add("09:00");
        alternativas.add("10:00");
        alternativas.add("11:00");
        alternativas.add("12:00");
        alternativas.add("13:00");
        alternativas.add("14:00");
        alternativas.add("15:00");
        alternativas.add("16:00");
        alternativas.add("17:00");
        alternativas.add("18:00");
        alternativas.add("19:00");
        alternativas.add("20:00");
        alternativas.add("21:00");
        alternativas.add("22:00");
        alternativas.add("23:00");
        combohoras.getItems().addAll(alternativas);
        combohoras.setOnAction(event -> {
            String selecionado= combohoras.getValue();
        });

    }
    public void registrarLembrete() {
        String titulo = txtitulo.getText();
        String descricao= txdescricao.getText();
        String horario = combohoras.getValue();

        if (titulo.length()== 0|| descricao.length() == 0|| horario == null){
            exibirAlerta(Alert.AlertType.WARNING, "Aviso", "Por favor,preencha todos os campos para continuar.");
            return;
        }
        Lembrete lembrete = new Lembrete(titulo, descricao, horario);
        BancoDeDados.lembretes.add(lembrete);
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
    public void limpar() {
        txtitulo.clear();
        txdescricao.clear();
        combohoras.setValue(null);
    }

}
