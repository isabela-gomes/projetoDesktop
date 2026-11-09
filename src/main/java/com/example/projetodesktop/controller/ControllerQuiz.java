package com.example.projetodesktop.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

public class ControllerQuiz {
    @FXML private ComboBox<String> cbAlimentacao,cbHidratacao,cbSono,cbMovimento,cbRotina;
    @FXML private Label lblResultado;
    @FXML public void initialize(){String[] opcoes={"🙁","😕","😐","🙂","😁"};for(ComboBox<String> c:new ComboBox[]{cbAlimentacao,cbHidratacao,cbSono,cbMovimento,cbRotina})c.getItems().addAll(opcoes);}
    @FXML private void finalizarQuiz(ActionEvent e){ComboBox<String>[] campos=new ComboBox[]{cbAlimentacao,cbHidratacao,cbSono,cbMovimento,cbRotina};int soma=0,respondidas=0;for(ComboBox<String> c:campos){if(c.getValue()!=null){soma+=switch(c.getValue()){case "🙁"->1;case "😕"->2;case "😐"->3;case "🙂"->4;default->5;};respondidas++;}}if(respondidas==0){lblResultado.setText("Selecione pelo menos uma resposta.");return;}double media=(double)soma/respondidas;if(media<2.5)lblResultado.setText("Sua semana parece ter sido desafiadora. Procure apoio e escolha uma pequena mudança possível.");else if(media<3.8)lblResultado.setText("Sua semana teve altos e baixos. Observe sua rotina com carinho e sem cobranças.");else lblResultado.setText("Que bom que sua experiência foi positiva! Continue cuidando de você.");}
    @FXML private void limpar(ActionEvent e){cbAlimentacao.setValue(null);cbHidratacao.setValue(null);cbSono.setValue(null);cbMovimento.setValue(null);cbRotina.setValue(null);lblResultado.setText("");}
    @FXML private void handleVoltar(ActionEvent e){Navegacao.abrir(e,"menu.fxml");}
}
