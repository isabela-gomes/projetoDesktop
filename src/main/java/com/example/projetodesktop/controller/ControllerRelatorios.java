package com.example.projetodesktop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerRelatorios {

    @FXML private BarChart<String, Number> graficoDisturbios;

    @FXML
    public void initialize() {
        XYChart.Series<String, Number> serie = new XYChart.Series<>();
        serie.setName("Resultados do Quiz Inicial");

        serie.getData().add(new XYChart.Data<>("Alimentação", 120));
        serie.getData().add(new XYChart.Data<>("Hidratação", 45));
        serie.getData().add(new XYChart.Data<>("Sono / Descanso", 28));
        serie.getData().add(new XYChart.Data<>("Movimento", 34));
        serie.getData().add(new XYChart.Data<>("Saúde e Rotina", 80));

        graficoDisturbios.getData().add(serie);
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
}