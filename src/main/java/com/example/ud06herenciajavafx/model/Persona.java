package com.example.ud06herenciajavafx.model;

public class Persona {
    private String dni;
    private String nombre;
    private int edad;


    public Persona(String dni, String nombre, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean esCorrectoNIF(String nif){


    }
}

