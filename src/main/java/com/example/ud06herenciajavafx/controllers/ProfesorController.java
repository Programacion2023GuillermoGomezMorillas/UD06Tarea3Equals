package com.example.ud06herenciajavafx.controllers;

import com.example.ud06herenciajavafx.model.Alumno;
import com.example.ud06herenciajavafx.model.Curso;
import com.example.ud06herenciajavafx.model.Persona;
import com.example.ud06herenciajavafx.model.Profesor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfesorController implements Initializable {

    private ObservableList<Profesor> listaProfesor;

    @FXML
    private TableColumn<Alumno, String> tcDni;

    @FXML
    private TextField tfSueldo;

    @FXML
    private TableColumn<Profesor, Integer> tcSueldo;

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
    private TableView<Profesor> tvAlumnos;

    @FXML
    private TextField tfDni;

    @FXML
    void onClickGuardar(ActionEvent event) {
        Profesor profesor = crearProfesor();
        //No hay errores
        if (profesor!=null){
            //guardamos el alumno
            listaProfesor.add(profesor);
            //limpiamos la entrada
            limpiaDatos();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        iniciaTableView();
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

    private Profesor crearProfesor() {
        Profesor profesor= null;
        String nombre = tfNombre.getText();
        //obtenemos el dni
        String dni = tfDni.getText();
        //sueldo seleccionado
        int sueldo;
        //edad
        int edad;
        //comprobación de errores
        //DNI
        if (!Persona.esCorrectoNIF(dni)) {
            iniciaAlertaError("El DNI es incorrecto");
            tfDni.requestFocus();//ponemos el foco en el campo nombre
        } else if (nombre.isEmpty()) {
            iniciaAlertaError("El profesor tiene que tener nombre");
            tfNombre.requestFocus();
            //edad
        } else if (tfEdad.getText().isEmpty()) {
            tfEdad.requestFocus();
            iniciaAlertaError("El profesor tiene que tener edad");
        } else if (tfSueldo.getText().isEmpty()) {
            tfEdad.requestFocus();
            iniciaAlertaError("El profesor tiene que tener sueldo");
        }else {
            try {//bloque que controla excepciones
                //si no contiene un entero, provocará una excepción
                edad = Integer.parseInt(tfEdad.getText());
                sueldo = Integer.parseInt(tfSueldo.getText());
                //creamos el profesor
                profesor = new Profesor(dni, nombre, edad, sueldo);
            } catch (NumberFormatException e) {
                //si salta la excepción mandamos un mensaje
                iniciaAlertaError("La edad y el sueldo tienen que ser números enteros");
                tfEdad.requestFocus();
            }

            }
        //devuelve null si hay error
        return profesor;
    }
    private void iniciaTableView(){
        // Inicializar la lista observable de alumnos
        listaProfesor = FXCollections.observableArrayList();
        //asociamos las columnas con los datos indicando el nombre del campo de la clase
        tcNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        tcDni.setCellValueFactory(new PropertyValueFactory("dni"));
        tcEdad.setCellValueFactory(new PropertyValueFactory("edad"));
        tcSueldo.setCellValueFactory(new PropertyValueFactory("sueldo"));
        //Asociamos la lista a la tabla
        tvAlumnos.setItems(listaProfesor);
    }
    private void limpiaDatos(){
        tfEdad.clear();
        tfNombre.clear();
        tfDni.clear();
    }

}