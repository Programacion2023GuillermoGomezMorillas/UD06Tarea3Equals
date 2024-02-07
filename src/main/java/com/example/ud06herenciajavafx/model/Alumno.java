package com.example.ud06herenciajavafx.model;

public class Alumno extends Persona{
    private Curso curso;
    public Alumno(String dni, String nombre, int edad) {
        super(dni, nombre, edad);
    }
    public Curso getCuerso(){
        return curso;
    }
    public void setCurso(Curso curso) {
            this.curso = curso;
    }
}