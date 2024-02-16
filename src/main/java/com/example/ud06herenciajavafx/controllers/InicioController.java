package com.example.ud06herenciajavafx.controllers;

import com.example.ud06herenciajavafx.IESOchoaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;

public class InicioController {

    @FXML
    private Button btAlumnos;

    @FXML
    private Button btProfesores;

    @FXML
    void onClickAlumnos(ActionEvent event) {
        abrirAlumnos();
    }
    @FXML
    void onClickProfesores(ActionEvent event) {
        abrirProfesores();
    }

    private void abrirAlumnos() {
        //es necesario el control de excepciones
        try{
            //cargamos la escena desde el recurso
            FXMLLoader loader=new FXMLLoader(IESOchoaApplication.class.getResource("alumno-view.fxml"));
            Parent root=loader.load();
            AlumnoController alumnoController=loader.getController();
            Scene scene=new Scene(root);
            //iniciamos nuevo stage en forma modal con la scene
            Stage stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    private void abrirProfesores() {
        //es necesario el control de excepciones
        try{
            //cargamos la escena desde el recurso
            FXMLLoader loader=new FXMLLoader(IESOchoaApplication.class.getResource("profesor-view.fxml"));
            Parent root=loader.load();
            AlumnoController alumnoController=loader.getController();
            Scene scene=new Scene(root);
            //iniciamos nuevo stage en forma modal con la scene
            Stage stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

}

