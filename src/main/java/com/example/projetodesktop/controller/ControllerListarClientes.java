package com.example.projetodesktop.controller;

import com.example.projetodesktop.database.BancoDeDados;
import com.example.projetodesktop.model.Cliente;
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
import javafx.scene.Node;

import java.io.IOException;

public class ControllerListarClientes {

    @FXML
    private TableView<Cliente> tbclientes;

    @FXML
    private TableColumn<Cliente, String> colnome;

    @FXML
    private TableColumn<Cliente, String> colgenero;

    @FXML
    private TableColumn<Cliente, String> colidade;

    @FXML
    private TableColumn<Cliente, String> colpeso;

    @FXML
    private TableColumn<Cliente, String> colconesp;

    private Cliente clienteRelatorio;
    private boolean relatorio = false;

    @FXML
    public void initialize() {
        colnome.setCellValueFactory(
                new PropertyValueFactory<>("Nome")
        );
        colgenero.setCellValueFactory(
                new PropertyValueFactory<>("Genero")
        );
        colidade.setCellValueFactory(
                new PropertyValueFactory<>("Idade")
        );
        colpeso.setCellValueFactory(
                new PropertyValueFactory<>("Peso")
        );
        colconesp.setCellValueFactory(
                new PropertyValueFactory<>("condicaoEspecial")
        );

        tbclientes.getItems().addAll(BancoDeDados.clientes);
        Cliente clienteTeste = new Cliente("João Silva", "Masculino", "45", "82.5", "Diabetes");
        tbclientes.getItems().add(clienteTeste);
    }

    public void irParaInicio(ActionEvent event) {
    }
    @FXML
    private TableView<Cliente> tabelaUsuarios;

    @FXML
    private void Relatorio(ActionEvent event) {

        Cliente usuarioExemplo = new Cliente(
                "Carlos Silva",
                "Masculino",
                42,
                84,
                "Hipertensão Gestacional / Diabetes Tipo 2"
        );

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/projetodesktop/view/Relatoriodeusuario.fxml"));
            Parent root = loader.load();


            ControllerRelatorioUsuario controllerRelatorio = loader.getController();


            controllerRelatorio.initData(usuarioExemplo);


            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exibirAlerta(Alert.AlertType tipo, String titulo, String message) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
