package com.example.fileviewer.controller;

import com.example.fileviewer.MainApplication;
import com.example.fileviewer.model.FileManager;
import com.example.fileviewer.model.MD5;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class InitController {


    boolean space = false;
    @FXML
    private Label alert;

    @FXML
    private TextField textField1;

    @FXML
    private TextField textField2;

    @FXML
    private TextField textField3;

    @FXML
    private TextField textField4;

    @FXML
    private TextField textField5;

    @FXML
    private TextField textField6;

    private static String password;

    public static String getInstace(){
        if(password==null){
            password = FileManager.readFile(2).replaceAll("\n", "");
        }
        return password;
    }

    public static void setInstance(String instance){
        password = instance;
    }
    @FXML
    protected void onOpenFileWindow() {
        String password = textField1.getText() + textField2.getText()+ textField3.getText()+ textField4.getText()+textField5.getText()+ textField6.getText();
        String actualPass = getInstace();
        password = MD5.getMD5Hash(password);
        if(password.equals(actualPass)){
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
            textField4.setText("");
            textField5.setText("");
            textField6.setText("");
            textField1.requestFocus();
            Scene scene = alert.getScene();
            Stage stage = (Stage)scene.getWindow();
            MainApplication.renderView("file-view.fxml");
            stage.close();
        }else{
            alert.setText("Contraseña incorrecta");
            textField1.requestFocus();
        }
    }

    public void initialize(){
        textField1.setOnKeyTyped(event -> {
            if(!space){
                alert.setText("");
            }
            space = false;
            // Obtener el carácter ingresado
            String character = event.getCharacter();

            // Si el carácter es un número, mover el enfoque al siguiente TextField
            if (character.matches("[0-9]")) {
                textField2.requestFocus();
            }
        });

        textField2.setOnKeyTyped(event -> {
            alert.setText("");
            // Obtener el carácter ingresado
            String character = event.getCharacter();

            // Si el carácter es un número, mover el enfoque al siguiente TextField
            if (character.matches("[0-9]")) {
                textField3.requestFocus();
            }

            if (textField2.getText().isEmpty() && !textField1.getText().isEmpty()) {
                textField1.requestFocus();
            }


        });

        // Agregar evento onKeyTyped al tercer TextField
        textField3.setOnKeyTyped(event -> {
            alert.setText("");
            // Obtener el carácter ingresado
            String character = event.getCharacter();

            // Si el carácter es un número y el TextField está vacío, mover el enfoque al TextField anterior
            if (character.matches("[0-9]")) {
                textField4.requestFocus();
            }

            if (textField3.getText().isEmpty() && !textField2.getText().isEmpty()) {
                textField2.requestFocus();
            }


        });

        textField4.setOnKeyTyped(event -> {
            alert.setText("");
            // Obtener el carácter ingresado
            String character = event.getCharacter();

            // Si el carácter es un número y el TextField está vacío, mover el enfoque al TextField anterior
            if (character.matches("[0-9]")) {
                textField5.requestFocus();
            }

            if (textField4.getText().isEmpty() && !textField3.getText().isEmpty()) {
                textField3.requestFocus();
            }


        });

        textField5.setOnKeyTyped(event -> {
            alert.setText("");
            // Obtener el carácter ingresado
            String character = event.getCharacter();

            // Si el carácter es un número y el TextField está vacío, mover el enfoque al TextField anterior
            if (character.matches("[0-9]")) {
                textField6.requestFocus();
            }

            if (textField5.getText().isEmpty() && !textField4.getText().isEmpty()) {
                textField4.requestFocus();
            }


        });

        textField6.setOnKeyTyped(event -> {
            if(!space){
                alert.setText("");
            }

            // Obtener el carácter ingresado

            if (textField6.getText().isEmpty() && !textField5.getText().isEmpty()) {
                textField5.requestFocus();
            }




        });

        textField6.setOnKeyPressed(event -> {
            // Verificar si la tecla presionada es Enter y si es así, llamar al método deseado
            if (event.getCode() == KeyCode.ENTER) {
                space = true;
                onOpenFileWindow();
            }
        });


    }

}