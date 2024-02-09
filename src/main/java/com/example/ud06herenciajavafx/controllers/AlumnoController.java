package com.example.ud06herenciajavafx.controllers;

import com.example.ud06herenciajavafx.model.Curso;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AlumnoController implements Initializable {


        @FXML
        private TableColumn<?, ?> tcDni;

        @FXML
        private TableColumn<?, ?> tcNombre;

        @FXML
        private TextField tfEdad;

        @FXML
        private TableColumn<?, ?> tcCurso;

        @FXML
        private TextField tfNombre;

        @FXML
        private ComboBox<String> cbCurso;

        @FXML
        private TableColumn<?, ?> tcEdad;

        @FXML
        private Button btGuardar;

        @FXML
        private TableView<?> tvAlumnos;

        @FXML
        private TextField tfDni;

        @FXML
        void onClickGuardar(ActionEvent event) {

        }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                iniciaCbCurso();
        }

        private void iniciaCbCurso() {
                //recuperamos todos los valores de Enum Curso
                Curso[] cursos = Curso.values();
                for (Curso curso : cursos) {
                        //los añadimos al comboBox
                        cbCurso.getItems().add(curso.toString());
                }
                //Seleccionamos el primero
                cbCurso.setValue(cursos[0].toString());
        }
}
