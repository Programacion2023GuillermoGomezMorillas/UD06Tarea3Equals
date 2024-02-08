module com.example.ud06herenciajavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ud06herenciajavafx to javafx.fxml;
    exports com.example.ud06herenciajavafx;
    exports com.example.ud06herenciajavafx.controllers;
    exports com.example.ud06herenciajavafx.model;
    opens com.example.ud06herenciajavafx.controllers to javafx.fxml;
}