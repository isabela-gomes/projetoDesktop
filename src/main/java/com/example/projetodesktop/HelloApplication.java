package com.example.projetodesktop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/projetodesktop/view/login.fxml"));
        Scene scene = new Scene(loader.load(), 620, 440);
        stage.setTitle("Nutricat");
        stage.setScene(scene);
        stage.setMinWidth(620);
        stage.setMinHeight(440);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
