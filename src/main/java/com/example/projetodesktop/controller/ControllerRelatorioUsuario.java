package com.example.projetodesktop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import com.example.projetodesktop.model.Cliente;
import javafx.scene.control.Label;

public class ControllerRelatorioUsuario {

    @FXML private AreaChart<String, Number> customerChart;
    @FXML private Button btnpeso;
    @FXML private Button btnagua;
    @FXML private Button btnsono;

    private Cliente clienteAtual;


    public void initData(Cliente cliente) {
        this.clienteAtual = cliente;


        carregarDadosPeso();
    }

    @FXML
    private void mostrarGraficoPeso(ActionEvent event) {
        carregarDadosPeso();
    }

    @FXML
    private void agua(ActionEvent event) {
        customerChart.getData().clear();
        customerChart.getYAxis().setLabel("LITROS (L)");

        XYChart.Series<String, Number> serieAgua = new XYChart.Series<>();
        serieAgua.setName("Consumo de Água");

        double aguaJulho = 2.0;
        double aguaAgosto = 1.0;
        double aguaSetembro = 2.0;
        double aguaOutubro = 2.0;

        double mediaAgua = (aguaJulho + aguaAgosto + aguaSetembro + aguaOutubro) / 4.0;
        lblMedia.setText(String.format("Media %.2f de agua tomada", mediaAgua));

        serieAgua.getData().add(new XYChart.Data<>("Julho", 2.5));
        serieAgua.getData().add(new XYChart.Data<>("Agosto", 3.0));
        serieAgua.getData().add(new XYChart.Data<>("Setembro", 2.8));
        serieAgua.getData().add(new XYChart.Data<>("Outubro", 3.2));

        customerChart.getData().add(serieAgua);
    }
    @FXML
    private void sono(ActionEvent event) {
        customerChart.getData().clear();
        customerChart.getYAxis().setLabel(" ");

        XYChart.Series<String, Number> serieSono = new XYChart.Series<>();
        serieSono.setName("Media de horas dormidas por mes");

        double sonoJulho = 7.8;
        double sonoAgosto = 8.0;
        double sonoSetewmbro = 6.0;
        double sonoOutubro = 5.0;


double mediasono = (sonoJulho + sonoAgosto + sonoSetewmbro + sonoOutubro) / 4.0;
        lblMedia.setText(String.format("Media de %.2f Horas dormidas", mediasono));
        serieSono.getData().add(new XYChart.Data<>("Julho", sonoJulho));
        serieSono.getData().add(new XYChart.Data<>("Agosto", sonoAgosto));
        serieSono.getData().add(new XYChart.Data<>("Setembro", sonoSetewmbro));
        serieSono.getData().add(new XYChart.Data<>("Outubro", sonoOutubro));

        customerChart.getData().add(serieSono);
    }
    @FXML
    private void exercicio(ActionEvent event) {
        customerChart.getData().clear();
        customerChart.getYAxis().setLabel(" ");

        XYChart.Series<String, Number> serieExercicip = new XYChart.Series<>();
        serieExercicip.setName("Media de horas de exercicio por mes");

        double exercicioJulho = 2.5;
        double exercicipAgosto = 3.0;
        double exercicioSetembro = 1.0;
        double exercicioOutubro = 1.2;



        double mediaAgua = (exercicioJulho + exercicipAgosto + exercicioSetembro + exercicioOutubro) / 4.0;
        lblMedia.setText(String.format("Media de %.2f Horas exercitadas", mediaAgua));

        serieExercicip.getData().add(new XYChart.Data<>("Julho", exercicioJulho));
        serieExercicip.getData().add(new XYChart.Data<>("Agosto", exercicipAgosto));
        serieExercicip.getData().add(new XYChart.Data<>("Setembro", exercicioSetembro));
        serieExercicip.getData().add(new XYChart.Data<>("Outubro", exercicioOutubro));

        customerChart.getData().add(serieExercicip);
    }



    @FXML private Label lblMedia;

    private void carregarDadosPeso() {
        customerChart.getData().clear();
        customerChart.getYAxis().setLabel("PESO (KG)");

        XYChart.Series<String, Number> seriePeso = new XYChart.Series<>();
        seriePeso.setName("Evolução de Peso");

        double pesoBase = 84.5;

        if (clienteAtual != null) {
            try {
                if (clienteAtual.getPeso() != null) {
                    pesoBase = Double.parseDouble(String.valueOf(clienteAtual.getPeso()));
                }
            } catch (Exception e) {
                pesoBase = 84.5;
            }
        }


        double pesoJulho = pesoBase + 4.0;
        double pesoAgosto = pesoBase + 2.1;
        double pesoSetembro = pesoBase + 0.8;
        double pesoOutubro = pesoBase;


        seriePeso.getData().add(new XYChart.Data<>("Julho", pesoJulho));
        seriePeso.getData().add(new XYChart.Data<>("Agosto", pesoAgosto));
        seriePeso.getData().add(new XYChart.Data<>("Setembro", pesoSetembro));
        seriePeso.getData().add(new XYChart.Data<>("Outubro", pesoOutubro));

        customerChart.getData().add(seriePeso);


        double mediaPeso = (pesoJulho + pesoAgosto + pesoSetembro + pesoOutubro) / 4.0;


        lblMedia.setText(String.format("Media %.2f kg de Peso", mediaPeso));
    }


}
