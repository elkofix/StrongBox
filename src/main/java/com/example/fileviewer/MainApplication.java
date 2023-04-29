package com.example.fileviewer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        renderView("init-view.fxml");
    }

    public static void renderView(String FXML){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(FXML));
            Scene scene = new Scene(fxmlLoader.load(), 400, 300);
            Stage stage = new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();

        }catch (IOException e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}