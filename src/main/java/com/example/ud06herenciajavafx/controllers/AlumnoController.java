package com.example.ud06herenciajavafx.controllers;

import com.example.ud06herenciajavafx.model.Alumno;
import com.example.ud06herenciajavafx.model.Curso;
import com.example.ud06herenciajavafx.model.Persona;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

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
                Alumno alumno = crearAlumno();
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
        private void iniciaAlertaError(String mensaje){
                //creamos la alerta de tipo Error
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                //mostramos el mensaje
                alert.setContentText(mensaje);
                alert.showAndWait();
        }
        private Alumno crearAlumno(){
                Alumno alumno=null;
                String nombre=tfNombre.getText();
                //obtenemos el dni
                String dni = tfDni.getText();
                //curso seleccionado
                Curso curso = Curso.valueOf(cbCurso.getValue());
                //edad
                int edad;

                //comprobación de errores
                //DNI
                if(!Persona.esCorrectoNIF(dni)){
                        iniciaAlertaError("El DNI es incorrecto");
                        tfDni.requestFocus();//ponemos el foco en el campo nombre
                }
                else if (nombre.isEmpty()){
                        iniciaAlertaError("El alumno tiene que tener nombre");
                        tfNombre.requestFocus();
                        //edad
                }
                return alumno;
        }
}