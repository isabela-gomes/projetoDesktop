package com.example.projetodesktop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

public class ControllerRelatorios {

    @FXML
    private BarChart<String, Number> graficoDisturbios;

    @FXML
    public void initialize() {
        XYChart.Series<String, Number> respostas = new XYChart.Series<>();
        respostas.setName("Média das respostas");

        respostas.getData().add(new XYChart.Data<>("Alimentação", 4));
        respostas.getData().add(new XYChart.Data<>("Hidratação", 3));
        respostas.getData().add(new XYChart.Data<>("Sono / Descanso", 4));
        respostas.getData().add(new XYChart.Data<>("Movimento", 2));
        respostas.getData().add(new XYChart.Data<>("Rotina", 5));

        graficoDisturbios.getData().setAll(respostas);
    }

    @FXML
    private void handleVoltar(ActionEvent event) {
        Navegacao.abrir(event, "menu.fxml");
    }
}
