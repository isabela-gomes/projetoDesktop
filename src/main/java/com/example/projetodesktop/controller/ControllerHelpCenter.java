package com.example.projetodesktop.controller;

import com.example.projetodesktop.model.GerenciadorDados;
import com.example.projetodesktop.model.GerenciadorDados.TicketModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;

import java.io.InputStream;

public class ControllerHelpCenter {
    @FXML
    private TableView<TicketModel> tabelaTickets;
    @FXML
    private TableColumn<TicketModel, String> colProtocolo, colUsuario, colTipo, colStatus, colDescricao;
    @FXML
    private TextArea taDescricao, taResposta;
    @FXML
    private ComboBox<String> cbStatus;
    @FXML
    private ImageView imgDenuncia;

    @FXML
    public void initialize() {
        colProtocolo.setCellValueFactory(new PropertyValueFactory<>("protocolo"));
        colUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        cbStatus.setItems(FXCollections.observableArrayList("Aberto", "Em Análise", "Resolvido", "Finalizado"));
        tabelaTickets.setItems(GerenciadorDados.getListaTickets());
        tabelaTickets.getSelectionModel().selectedItemProperty().addListener((obs, old, t) -> mostrarTicket(t));
        tabelaTickets.getSelectionModel().selectFirst();
    }

    private void mostrarTicket(TicketModel t) {
        if (t == null) {
            taDescricao.clear();
            taResposta.clear();
            imgDenuncia.setImage(null);
            return;
        }
        taDescricao.setText("Protocolo: " + t.getProtocolo() + "\nQuem reportou: " + t.getUsuario() + "\nUsuário denunciado: " + (vazio(t.getDenunciado()) ? "Não informado" : t.getDenunciado()) + "\nTipo: " + t.getTipo() + "\n\nDescrição / mensagem:\n" + t.getDescricao());
        cbStatus.setValue(t.getStatus());
        taResposta.setText(t.getResposta() == null ? "" : t.getResposta());
        imgDenuncia.setImage(null);
        if (!vazio(t.getCaminhoImagem())) {
            try (InputStream in = getClass().getResourceAsStream(t.getCaminhoImagem())) {
                if (in != null) imgDenuncia.setImage(new Image(in));
            } catch (Exception ignored) {
                imgDenuncia.setImage(null);
            }
        }
    }

    private boolean vazio(String s) {
        return s == null || s.isBlank();
    }

    @FXML
    private void handleBanirDenunciado(ActionEvent e) {
        TicketModel t = tabelaTickets.getSelectionModel().getSelectedItem();
        if (t == null || vazio(t.getDenunciado())) {
            alerta(Alert.AlertType.WARNING, "Aviso", "Selecione uma denúncia com usuário identificado.");
            return;
        }
        GerenciadorDados.UsuarioModel u = GerenciadorDados.buscarCliente(t.getDenunciado());
        if (u == null) {
            alerta(Alert.AlertType.WARNING, "Aviso", "Usuário não encontrado.");
            return;
        }
        if (u.getStatus().startsWith("Banido")) {
            alerta(Alert.AlertType.INFORMATION, "Atenção", "Este usuário já está banido.");
            return;
        }
        Alert c = new Alert(Alert.AlertType.CONFIRMATION, "Deseja banir " + u.getLogin() + "?", ButtonType.YES, ButtonType.NO);
        c.setHeaderText("Confirmar banimento");
        if (c.showAndWait().orElse(ButtonType.NO) == ButtonType.YES) {
            u.setStatus("Banido (Via Help Center - " + t.getTipo() + ")");
            t.setStatus("Em Análise");
            cbStatus.setValue("Em Análise");
            tabelaTickets.refresh();
            alerta(Alert.AlertType.INFORMATION, "Sucesso", "Usuário banido pelo ticket " + t.getProtocolo() + ".");
        }
    }

    @FXML
    private void handleSalvarAlteracoes(ActionEvent e) {
        TicketModel t = tabelaTickets.getSelectionModel().getSelectedItem();
        if (t == null) {
            alerta(Alert.AlertType.WARNING, "Aviso", "Selecione um ticket.");
            return;
        }
        if (cbStatus.getValue() != null) t.setStatus(cbStatus.getValue());
        t.setResposta(taResposta.getText());
        tabelaTickets.refresh();
        alerta(Alert.AlertType.INFORMATION, "Sucesso", "Ticket atualizado.");
    }

    @FXML
    private void handleVoltar(ActionEvent e) {
        Navegacao.abrir(e, "menu.fxml");
    }

    private void alerta(Alert.AlertType tipo, String titulo, String msg) {
        Alert a = new Alert(tipo);
        a.setTitle(titulo);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }
}
