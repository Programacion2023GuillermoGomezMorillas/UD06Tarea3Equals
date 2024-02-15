package com.example.ud06herenciajavafx.model;

public class Profesor extends Persona{
    private int sueldo;


    public Profesor(String dni, String nombre, int edad, int sueldo) {
        super(dni, nombre, edad);
        this.sueldo = sueldo;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        if (sueldo > 0) {
            this.sueldo = sueldo;
        }
        else {
            this.sueldo=0;
        }
    }
}

