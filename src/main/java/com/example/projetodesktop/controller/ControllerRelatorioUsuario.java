package com.example.projetodesktop.controller;

import com.example.projetodesktop.model.GerenciadorDados.UsuarioModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class ControllerRelatorioUsuario {

    @FXML private AreaChart<String, Number> customerChart;
    @FXML private Label lblMedia;
    @FXML private Label lblNome;

    public void initData(UsuarioModel usuario) {
        lblNome.setText("Relatório de " + usuario.getLogin());
        agua(null);
    }

    @FXML
    private void agua(ActionEvent event) {
        mostrarGrafico("Consumo de Água", "Litros (L)",
                new double[]{2.0, 1.0, 2.0, 2.0}, "Média de %.2f litros");
    }

    @FXML
    private void sono(ActionEvent event) {
        mostrarGrafico("Horas de Sono", "Horas", 
                new double[]{7.8, 8.0, 6.0, 5.0}, "Média de %.2f horas de sono");
    }

    @FXML
    private void exercicio(ActionEvent event) {
        mostrarGrafico("Movimento e Disposição", "Horas",
                new double[]{2.5, 3.0, 1.0, 1.2}, "Média de %.2f horas de movimento");
    }

    private void mostrarGrafico(String titulo, String eixo, double[] valores, String textoMedia) {
        customerChart.getData().clear();
        customerChart.getYAxis().setLabel(eixo);

        XYChart.Series<String, Number> serie = new XYChart.Series<>();
        serie.setName(titulo);

        String[] meses = {"Julho", "Agosto", "Setembro", "Outubro"};
        double soma = 0;

        for (int i = 0; i < valores.length; i++) {
            serie.getData().add(new XYChart.Data<>(meses[i], valores[i]));
            soma += valores[i];
        }

        customerChart.getData().add(serie);
        lblMedia.setText(String.format(textoMedia, soma / valores.length));
    }

    @FXML
    private void handleVoltar(ActionEvent event) {
        Navegacao.abrir(event, "ListaDeUsuarios.fxml");
    }
}
