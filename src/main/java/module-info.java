module com.example.ud06herenciajavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ud06herenciajavafx to javafx.fxml;
    exports com.example.ud06herenciajavafx;
}