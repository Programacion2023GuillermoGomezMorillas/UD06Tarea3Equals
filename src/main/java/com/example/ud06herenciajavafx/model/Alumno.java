package com.example.ud06herenciajavafx.model;

public class Alumno extends Persona{
    private Curso curso;
    public Alumno(String dni, String nombre, int edad, Curso curso) {
        super(dni, nombre, edad);
        this.curso = curso;
    }


    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}