package com.example.projetodesktop.controller;

import com.example.projetodesktop.model.GerenciadorDados;
import com.example.projetodesktop.model.GerenciadorDados.TicketModel;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerHelpCenter {

    @FXML private TableView<TicketModel> tabelaTickets;
    @FXML private TableColumn<TicketModel, String> colProtocolo;
    @FXML private TableColumn<TicketModel, String> colUsuario;
    @FXML private TableColumn<TicketModel, String> colTipo;
    @FXML private TableColumn<TicketModel, String> colStatus;
    @FXML private TableColumn<TicketModel, String> colDescricao;

    @FXML private TextArea taDescricao;
    @FXML private ComboBox<String> cbStatus;
    @FXML private TextArea taResposta;

    @FXML
    public void initialize() {
        colProtocolo.setCellValueFactory(new PropertyValueFactory<>("protocolo"));
        colUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));

        cbStatus.setItems(FXCollections.observableArrayList("Aberto", "Em Análise", "Resolvido", "Finalizado"));
        tabelaTickets.setItems(GerenciadorDados.getListaTickets());

        tabelaTickets.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                taDescricao.setText("Protocolo: " + newSel.getProtocolo() + "\n" +
                        "Usuário: " + newSel.getUsuario() + "\n" +
                        "Tipo: " + newSel.getTipo() + "\n\n" +
                        "Descrição:\n" + newSel.getDescricao());
                cbStatus.setValue(newSel.getStatus());
                taResposta.setText(newSel.getResposta() != null ? newSel.getResposta() : "");
            }
        });
    }

    @FXML
    private void handleSalvarAlteracoes(ActionEvent event) {
        TicketModel selecionado = tabelaTickets.getSelectionModel().getSelectedItem();
        if (selecionado == null) {
            exibirAlerta("Aviso", "Selecione um ticket na tabela para modificar.");
            return;
        }

        if (cbStatus.getValue() != null) {
            selecionado.setStatus(cbStatus.getValue());
        }
        selecionado.setResposta(taResposta.getText());

        tabelaTickets.refresh();
        exibirAlerta("Sucesso", "Ticket " + selecionado.getProtocolo() + " atualizado com sucesso!");
    }

    @FXML
    private void handleVoltar(ActionEvent event) {
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

    private void exibirAlerta(String titulo, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}