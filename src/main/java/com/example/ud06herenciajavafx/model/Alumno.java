package com.example.ud06herenciajavafx.model;

public class Alumno extends Persona{

    public Alumno(String dni, String nombre, int edad) {
        super(dni, nombre, edad);
    }
    public Curso getCuerso(){
        return Curso.DAM;
    }
    public void setCurso(Curso curso) {
        if (curso == Curso.DAM) {
            curso = Curso.DAM;
        }
        if (curso == Curso.DAW) {
            curso = Curso.DAW;
        }
        if (curso == Curso.SMR) {
            curso = Curso.SMR;
        }
    }

}
