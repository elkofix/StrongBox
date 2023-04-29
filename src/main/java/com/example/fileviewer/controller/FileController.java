package com.example.fileviewer.controller;

import com.example.fileviewer.MainApplication;
import com.example.fileviewer.model.FileManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class FileController {

    
    private static String content;
    public Button fileOpenBtn;


    @FXML
    private TextArea fileViewTA;

    public static String getInstance(){
        if(content == null){
            content = "";
        }
        return content;
    }

    @FXML
    protected void onOpenChangeWindow() {
        Stage stage = (Stage)fileOpenBtn.getScene().getWindow();
        MainApplication.renderView("change-view.fxml");
        stage.close();
    }


    public void initialize(){
        fileViewTA.setText(FileManager.readFile(1));
        fileViewTA.setOnKeyTyped(event->{
            content = fileViewTA.getText();
            FileManager.writeFile(content, 1);
        });
    }

    @FXML
    private void cerrarVentana(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        MainApplication.renderView("init-view.fxml");
        stage.close();
    }
}
