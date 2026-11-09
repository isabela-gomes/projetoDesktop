package com.example.projetodesktop.controller;

import com.example.projetodesktop.database.BancoDeDados;
import com.example.projetodesktop.model.Lembrete;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;

public class ControllerRegistroLembrete {
    @FXML
    private TextField txtitulo, txdescricao;
    @FXML
    private ComboBox<String> combohoras;
    @FXML
    private TableView<Lembrete> tabelaLembretes;
    @FXML
    private TableColumn<Lembrete, String> colTitulo, colDescricao, colHorario;

    @FXML
    public void initialize() {
        for (int h = 0; h < 24; h++) combohoras.getItems().add(String.format("%02d:00", h));

            colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
            colDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
            colHorario.setCellValueFactory(new PropertyValueFactory<>("horario"));
            tabelaLembretes.setItems(BancoDeDados.lembretes);

    }

    @FXML
    public void registrarLembrete() {
        String t = txtitulo.getText() == null ? "" : txtitulo.getText().trim();
        String d = txdescricao.getText() == null ? "" : txdescricao.getText().trim();
        String h = combohoras.getValue();
        if (t.isEmpty() || d.isEmpty() || h == null) {
            alerta(Alert.AlertType.WARNING, "Aviso", "Preencha título, descrição e horário.");
            return;
        }
        BancoDeDados.lembretes.add(new Lembrete(t, d, h));
        limpar();
        alerta(Alert.AlertType.INFORMATION, "Cadastro completo", "Lembrete registrado.");
    }

    @FXML
    public void limpar() {
        txtitulo.clear();
        txdescricao.clear();
        combohoras.setValue(null);
    }

    @FXML
    private void handleVoltar(ActionEvent e) {
        Navegacao.abrir(e, "menu.fxml");
    }

    private void alerta(Alert.AlertType t, String h, String m) {
        Alert a = new Alert(t);
        a.setTitle(h);
        a.setHeaderText(null);
        a.setContentText(m);
        a.showAndWait();
    }
}
