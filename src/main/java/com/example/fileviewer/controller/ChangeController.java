package com.example.fileviewer.controller;
import com.example.fileviewer.MainApplication;
import com.example.fileviewer.model.FileManager;
import com.example.fileviewer.model.MD5;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class ChangeController {

    @FXML
    private void cerrarVentana(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        MainApplication.renderView("file-view.fxml");
        stage.close();
    }

    private final MD5 md5 = MD5.getInstance();


    boolean space = false;
    @FXML
    private Label alert;


    @FXML
    private TextField textField1;
    @FXML
    private TextField textField12;

    @FXML
    private TextField textField2;

    @FXML
    private TextField textField22;

    @FXML
    private TextField textField3;
    @FXML
    private TextField textField32;

    @FXML
    private TextField textField4;

    @FXML
    private TextField textField42;

    @FXML
    private TextField textField5;

    @FXML
    private TextField textField52;

    @FXML
    private TextField textField6;
    @FXML
    private TextField textField62;


    @FXML
    protected void onChangePassword() {
        alert.setStyle("-fx-text-fill: RED; -fx-font-weight: bold");
        String password = textField1.getText() + textField2.getText()+ textField3.getText()+ textField4.getText()+textField5.getText()+ textField6.getText();
        password = MD5.getMD5Hash(password);
        if(password.equals(InitController.getInstace())){
            String newPassword = textField12.getText() + textField22.getText()+ textField32.getText()+ textField42.getText()+textField52.getText()+ textField62.getText();
            if(newPassword.length() > 6){
                alert.setText("La NUEVA clave tiene mas de 6 caracteres");
                textField12.requestFocus();
            }else if(newPassword.length()<6){
                alert.setText("La NUEVA clave tiene menos de 6 caracteres");
                textField12.requestFocus();
            }else{
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
                textField6.setText("");
                textField12.setText("");
                textField22.setText("");
                textField32.setText("");
                textField42.setText("");
                textField52.setText("");
                textField62.setText("");
                alert.setStyle("-fx-text-fill: GREEN; -fx-font-weight: bold");
                String hash = md5.getMD5Hash(newPassword);
                InitController.setInstance(hash);
                FileManager.writeFile(hash, 2);
                alert.setText("Clave actualizada ✓");
            }
        }else{
            alert.setText("Su clave actual no coincide con la ingresada");
            textField1.requestFocus();
        }
    }



    public void initialize(){
        textField12.setOnKeyTyped(event -> {
            if(!space){
                alert.setText("");
            }
            space = false;
            // Obtener el carácter ingresado
            String character = event.getCharacter();

            // Si el carácter es un número, mover el enfoque al siguiente TextField
            if (character.matches("[0-9]")) {
                textField22.requestFocus();
            }
        });

        textField22.setOnKeyTyped(event -> {
            alert.setText("");
            // Obtener el carácter ingresado
            String character = event.getCharacter();

            // Si el carácter es un número, mover el enfoque al siguiente TextField
            if (character.matches("[0-9]")) {
                textField32.requestFocus();
            }

            if (textField22.getText().isEmpty() && !textField12.getText().isEmpty()) {
                textField12.requestFocus();
            }


        });


        // Agregar evento onKeyTyped al tercer TextField
        textField32.setOnKeyTyped(event -> {
            alert.setText("");
            // Obtener el carácter ingresado
            String character = event.getCharacter();

            // Si el carácter es un número y el TextField está vacío, mover el enfoque al TextField anterior
            if (character.matches("[0-9]")) {
                textField42.requestFocus();
            }

            if (textField32.getText().isEmpty() && !textField22.getText().isEmpty()) {
                textField22.requestFocus();
            }


        });

        textField42.setOnKeyTyped(event -> {
            alert.setText("");
            // Obtener el carácter ingresado
            String character = event.getCharacter();

            // Si el carácter es un número y el TextField está vacío, mover el enfoque al TextField anterior
            if (character.matches("[0-9]")) {
                textField52.requestFocus();
            }

            if (textField42.getText().isEmpty() && !textField32.getText().isEmpty()) {
                textField32.requestFocus();
            }


        });

        textField52.setOnKeyTyped(event -> {
            alert.setText("");
            // Obtener el carácter ingresado
            String character = event.getCharacter();

            // Si el carácter es un número y el TextField está vacío, mover el enfoque al TextField anterior
            if (character.matches("[0-9]")) {
                textField62.requestFocus();
            }

            if (textField52.getText().isEmpty() && !textField42.getText().isEmpty()) {
                textField42.requestFocus();
            }


        });

        textField62.setOnKeyTyped(event -> {
            if(!space){
                alert.setText("");
            }

            // Obtener el carácter ingresado

            if (textField62.getText().isEmpty() && !textField52.getText().isEmpty()) {
                textField52.requestFocus();
            }




        });

        textField62.setOnKeyPressed(event -> {
            // Verificar si la tecla presionada es Enter y si es así, llamar al método deseado
            if (event.getCode() == KeyCode.ENTER) {
                space = true;
                onChangePassword();
            }
        });


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
                textField12.requestFocus();
            }
        });


    }


}
