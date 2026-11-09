package com.example.projetodesktop.controller;

import com.example.projetodesktop.model.GerenciadorDados;
import com.example.projetodesktop.model.GerenciadorDados.UsuarioModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.Optional;

public class ControllerRegistroLogins {

    @FXML private TableView<UsuarioModel> tabelaUsuarios;
    @FXML private TableColumn<UsuarioModel, String> colUsuario;
    @FXML private TableColumn<UsuarioModel, String> colStatus;
    @FXML private TableColumn<UsuarioModel, String> colDataCadastro;
    @FXML private TableColumn<UsuarioModel, Integer> colIdadeuser;

    @FXML
    public void initialize() {
        colUsuario.setCellValueFactory(new PropertyValueFactory<>("login"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colDataCadastro.setCellValueFactory(new PropertyValueFactory<>("dataCadastro"));
        colIdadeuser.setCellValueFactory(new PropertyValueFactory<>("idade"));

        tabelaUsuarios.setItems(GerenciadorDados.getListaClientes());
    }

    @FXML
    private void handleBanirUsuario(ActionEvent event) {
        UsuarioModel usuario = tabelaUsuarios.getSelectionModel().getSelectedItem();

        if (usuario == null) {
            alerta("Aviso", "Selecione um cliente.");
            return;
        }

        TextInputDialog dialogo = new TextInputDialog();
        dialogo.setTitle("Banir cliente");
        dialogo.setHeaderText("Banir " + usuario.getLogin());
        dialogo.setContentText("Motivo:");

        Optional<String> motivo = dialogo.showAndWait();
        motivo.ifPresent(texto -> {
            if (texto.isBlank()) {
                usuario.setStatus("Banido (Sem motivo)");
            } else {
                usuario.setStatus("Banido (" + texto.trim() + ")");
            }
            tabelaUsuarios.refresh();
            alerta("Sucesso", "Cliente banido.");
        });
    }

    @FXML
    private void handleDesbanirUsuario(ActionEvent event) {
        UsuarioModel usuario = tabelaUsuarios.getSelectionModel().getSelectedItem();

        if (usuario == null) {
            alerta("Aviso", "Selecione um cliente.");
            return;
        }

        if (!usuario.getStatus().startsWith("Banido")) {
            alerta("Aviso", "Este cliente não está banido.");
            return;
        }

        usuario.setStatus("Ativo");
        tabelaUsuarios.refresh();
        alerta("Sucesso", "Cliente desbanido.");
    }

    @FXML
    private void handleExcluirUsuario(ActionEvent event) {
        UsuarioModel usuario = tabelaUsuarios.getSelectionModel().getSelectedItem();

        if (usuario == null) {
            alerta("Aviso", "Selecione um cliente.");
            return;
        }

        Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION,
                "Excluir '" + usuario.getLogin() + "'?", ButtonType.YES, ButtonType.NO);

        if (confirmacao.showAndWait().orElse(ButtonType.NO) == ButtonType.YES) {
            GerenciadorDados.getListaClientes().remove(usuario);
        }
    }

    @FXML
    private void handleVoltar(ActionEvent event) {
        Navegacao.abrir(event, "menu.fxml");
    }

    private void alerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
