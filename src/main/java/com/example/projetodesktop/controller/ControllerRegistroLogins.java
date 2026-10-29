package com.example.projetodesktop.controller;

import com.example.projetodesktop.model.GerenciadorDados;
import com.example.projetodesktop.model.GerenciadorDados.UsuarioModel;
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
import java.util.Optional;

public class ControllerRegistroLogins {

    @FXML private TableView<UsuarioModel> tabelaUsuarios;
    @FXML private TableColumn<UsuarioModel, String> colUsuario;
    @FXML private TableColumn<UsuarioModel, String> colStatus;
    @FXML private TableColumn<UsuarioModel, String> colDataCadastro;
    @FXML private TableColumn<UsuarioModel, Integer> colIdadeuser; // Alterado para Integer

    @FXML
    public void initialize() {
        colUsuario.setCellValueFactory(new PropertyValueFactory<>("login"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colDataCadastro.setCellValueFactory(new PropertyValueFactory<>("dataCadastro"));
        colIdadeuser.setCellValueFactory(new PropertyValueFactory<>("idade")); // Vínculo com o atributo idade

        tabelaUsuarios.setItems(GerenciadorDados.getListaClientes());
    }

    @FXML
    private void handleBanirUsuario(ActionEvent event) {
        UsuarioModel selecionado = tabelaUsuarios.getSelectionModel().getSelectedItem();
        if (selecionado == null) {
            exibirAlerta("Aviso", "Selecione um cliente para banir.");
            return;
        }

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Banir Cliente");
        dialog.setHeaderText("Banir cliente: " + selecionado.getLogin());
        dialog.setContentText("Informe o motivo do banimento:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(motivo -> {
            if (motivo.trim().isEmpty()) {
                motivo = "Sem motivo especificado";
            }
            selecionado.setStatus("Banido (" + motivo + ")");
            tabelaUsuarios.refresh();
            exibirAlerta("Cliente Banido", "O cliente " + selecionado.getLogin() + " foi banido.");
        });
    }

    @FXML
    private void handleDesbanirUsuario(ActionEvent event) {
        UsuarioModel selecionado = tabelaUsuarios.getSelectionModel().getSelectedItem();
        if (selecionado == null) {
            exibirAlerta("Aviso", "Selecione um cliente para desbanir.");
            return;
        }

        if (!selecionado.getStatus().startsWith("Banido")) {
            exibirAlerta("Aviso", "Este cliente não está banido.");
            return;
        }

        selecionado.setStatus("Ativo");
        tabelaUsuarios.refresh();
        exibirAlerta("Sucesso", "O cliente " + selecionado.getLogin() + " foi desbanido.");
    }

    @FXML
    private void handleExcluirUsuario(ActionEvent event) {
        UsuarioModel selecionado = tabelaUsuarios.getSelectionModel().getSelectedItem();
        if (selecionado == null) {
            exibirAlerta("Aviso", "Selecione um cliente para excluir.");
            return;
        }

        Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacao.setTitle("Confirmar Exclusão");
        confirmacao.setHeaderText("Excluir Cliente");
        confirmacao.setContentText("Tem certeza que deseja excluir o cliente '" + selecionado.getLogin() + "'?");

        Optional<ButtonType> result = confirmacao.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            GerenciadorDados.getListaClientes().remove(selecionado);
            exibirAlerta("Sucesso", "Cliente excluído permanentemente.");
        }
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