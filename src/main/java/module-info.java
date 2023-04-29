module com.example.fileviewer {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fileviewer to javafx.fxml;
    exports com.example.fileviewer;
    exports com.example.fileviewer.controller;
    opens com.example.fileviewer.controller to javafx.fxml;
}