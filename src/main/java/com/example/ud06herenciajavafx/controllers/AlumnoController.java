package com.example.ud06herenciajavafx.controllers;

import com.example.ud06herenciajavafx.model.Alumno;
import com.example.ud06herenciajavafx.model.Curso;
import com.example.ud06herenciajavafx.model.Persona;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

    public class AlumnoController implements Initializable {

        private ObservableList<Alumno> listaAlumnos;

        @FXML
        private TableColumn<Alumno, String> tcDni;

        @FXML
        private TableColumn<Alumno, String> tcNombre;

        @FXML
        private TextField tfEdad;

        @FXML
        private TableColumn<Alumno, Curso> tcCurso;

        @FXML
        private TextField tfNombre;

        @FXML
        private ComboBox<String> cbCurso;

        @FXML
        private TableColumn<Alumno, Integer> tcEdad;

        @FXML
        private Button btGuardar;

        @FXML
        private TableView<Alumno> tvAlumnos;

        @FXML
        private TextField tfDni;
        @FXML
        void onClickTvAlumnos(MouseEvent event) {
            //buscamos el alumno seleccionado
            Alumno alumno=tvAlumnos.getSelectionModel().getSelectedItem();
            //si hay un alumno seleccionado mostramos los datos
            if(alumno!=null){
                tfDni.setText(alumno.getDni());
                tfNombre.setText(alumno.getNombre());
                tfEdad.setText(String.valueOf(alumno.getEdad()));
                cbCurso.setValue(alumno.getCurso().toString());
            }

        }

        @FXML
        void onClickGuardar(ActionEvent event) {
                Alumno alumno = crearAlumno();
                //No hay errores
                if (alumno!=null){
                        //guardamos el alumno
                        listaAlumnos.add(alumno);
                        //limpiamos la entrada
                        limpiaDatos();
                }
        }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

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

        private void iniciaAlertaError(String mensaje) {
                //creamos la alerta de tipo Error
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                //mostramos el mensaje
                alert.setContentText(mensaje);
                alert.showAndWait();
        }

        private Alumno crearAlumno() {
                Alumno alumno = null;
                String nombre = tfNombre.getText();
                //obtenemos el dni
                String dni = tfDni.getText();
                //curso seleccionado
                Curso curso = Curso.valueOf(cbCurso.getValue());
                //edad
                int edad;

                //comprobación de errores
                //DNI
                if (!Persona.esCorrectoNIF(dni)) {
                        iniciaAlertaError("El DNI es incorrecto");
                        tfDni.requestFocus();//ponemos el foco en el campo nombre
                } else if (nombre.isEmpty()) {
                        iniciaAlertaError("El alumno tiene que tener nombre");
                        tfNombre.requestFocus();
                        //edad
                } else if (tfEdad.getText().isEmpty()) {
                        tfEdad.requestFocus();
                        iniciaAlertaError("El Alumno tiene que tener edad");
                } else {
                        try {//bloque que controla excepciones
                                //si no contiene un entero, provocará una excepción
                                edad = Integer.parseInt(tfEdad.getText());
                                //creamos el alumno
                                alumno = new Alumno(dni, nombre, edad, curso);
                        } catch (NumberFormatException e) {
                                //si salta la excepción mandamos un mensaje
                                iniciaAlertaError("La edad tiene que ser un número entero");
                                tfEdad.requestFocus();
                        }
                }
                //devuelve null si hay error
                return alumno;
        }
        private void iniciaTableView(){
                // Inicializar la lista observable de alumnos
                // listaAlumnos = FXCollections.observableArrayList();
                //asociamos las columnas con los datos indicando el nombre del campo de la clase
                tcNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
                tcDni.setCellValueFactory(new PropertyValueFactory("dni"));
                tcEdad.setCellValueFactory(new PropertyValueFactory("edad"));
                tcCurso.setCellValueFactory(new PropertyValueFactory("curso"));
                //Asociamos la lista a la tabla
                tvAlumnos.setItems(listaAlumnos);
        }
        private void limpiaDatos(){
                tfEdad.clear();
                tfNombre.clear();
                tfDni.clear();
        }
        public void initialize (ObservableList<Alumno> listaAlumnos){
                //inicia comboBox
                iniciaCbCurso();
                //asignamos la lista
                this.listaAlumnos=listaAlumnos;
                //iniciamos la tabala
                iniciaTableView();
        }

    }