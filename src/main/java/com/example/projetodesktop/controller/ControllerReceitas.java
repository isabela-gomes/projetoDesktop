package com.example.projetodesktop.controller;

import com.example.projetodesktop.database.BancoDeDados;
import com.example.projetodesktop.model.Receita;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

public class ControllerReceitas {

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtAlergicos;

    @FXML
    private TextField txtTabelaNutricional;

    @FXML
    private TextArea txtReceita;

    @FXML
    private TableView<Receita> tabelaReceitas;

    @FXML
    private TableColumn<Receita, String> colNome;

    @FXML
    private TableColumn<Receita, String> colReceita;

    @FXML
    private TableColumn<Receita, String> colAlergicos;

    @FXML
    private Label lblArquivo;

    @FXML
    public void initialize() {
        if (tabelaReceitas != null) {
            colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            colReceita.setCellValueFactory(new PropertyValueFactory<>("receita"));
            colAlergicos.setCellValueFactory(new PropertyValueFactory<>("alergicos"));
            tabelaReceitas.setItems(BancoDeDados.receitas);
        }
    }

    @FXML
    public void RegistrarReceitas() {
        String nome = txtNome.getText().trim();
        String receita = txtReceita.getText().trim();
        String alergicos = txtAlergicos.getText().trim();
        String tabela = txtTabelaNutricional.getText().trim();

        if (nome.isEmpty() || receita.isEmpty() || alergicos.isEmpty() || tabela.isEmpty()) {
            alerta(Alert.AlertType.WARNING, "Aviso", "Preencha todos os campos da receita.");
            return;
        }

        Receita novaReceita = new Receita(nome, receita, alergicos, tabela);
        BancoDeDados.receitas.add(novaReceita);

        limpar();
        alerta(Alert.AlertType.INFORMATION, "Cadastro completo", "Receita cadastrada.");
    }

    @FXML
    public void ExcluirReceita() {
        Receita receitaSelecionada = tabelaReceitas.getSelectionModel().getSelectedItem();

        if (receitaSelecionada == null) {
            limpar();
            return;
        }

        BancoDeDados.receitas.remove(receitaSelecionada);
    }

    @FXML
    private void selecionarArquivos(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecione a imagem da receita");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Imagens", "*.png", "*.jpg", "*.jpeg")
        );

        Node componente = (Node) event.getSource();
        Stage janela = (Stage) componente.getScene().getWindow();
        File arquivo = fileChooser.showOpenDialog(janela);

        if (arquivo != null && lblArquivo != null) {
            lblArquivo.setText(arquivo.getName());
        }
    }

    @FXML
    private void handleVoltar(ActionEvent event) {
        Navegacao.abrir(event, "menu.fxml");
    }

    private void limpar() {
        txtNome.clear();
        txtReceita.clear();
        txtAlergicos.clear();
        txtTabelaNutricional.clear();
    }

    private void alerta(Alert.AlertType tipo, String titulo, String mensagem) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
}
