package com.example.projetodesktop.controller;

import com.example.projetodesktop.model.GerenciadorDados;
import com.example.projetodesktop.model.GerenciadorDados.UsuarioModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ControllerListarClientes {

    @FXML private TableView<UsuarioModel> tbclientes;
    @FXML private TableColumn<UsuarioModel, String> colnome;
    @FXML private TableColumn<UsuarioModel, String> colstatus;
    @FXML private TableColumn<UsuarioModel, String> coldata;
    @FXML private TableColumn<UsuarioModel, Integer> colidade;

    @FXML
    public void initialize() {
        colnome.setCellValueFactory(new PropertyValueFactory<>("login"));
        colstatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        coldata.setCellValueFactory(new PropertyValueFactory<>("dataCadastro"));
        colidade.setCellValueFactory(new PropertyValueFactory<>("idade"));

        tbclientes.setItems(GerenciadorDados.getListaClientes());
    }

    @FXML
    private void Relatorio(ActionEvent event) {
        UsuarioModel usuario = tbclientes.getSelectionModel().getSelectedItem();

        if (usuario == null) {
            alerta("Aviso", "Selecione um usuário para visualizar o relatório.");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/com/example/projetodesktop/view/RelatoriodeUsuario.fxml"));
            Parent root = loader.load();

            ControllerRelatorioUsuario controller = loader.getController();
            controller.initData(usuario);

            Stage stage = (Stage) tbclientes.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            alerta("Erro", "Não foi possível abrir o relatório.");
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
