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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public static String esCorrectoNIF(String nif){
        boolean nifCorrecto = false;
        String nifValido;
        String letrasNif = "TRWAGMYFPDXBNJZSQVHLCKE";
        //Convierto el los 8 numeros en un int
        int soloNumeroNif = Integer.parseInt(nif.substring(0, 8));
        //Guardo solo la letra en una variable
        String letra = nif.substring(8);
        //Guardo el resto del DNI en una variable
        int moduloNif = soloNumeroNif % 23;
        //Primero compruebo el largo de la cadena de texto, segundo compruebo que los numeros son números, tercero compruebo que la ultima posicion de dni es una letra, y por ultimo compruebo que la letra es igual que la letra en la posición de el modulo
        if (nif.length() == 9 && nif.substring(0, 8).matches("[0-9]*") && letra.matches("[A-Za-z]*") && letra.equalsIgnoreCase(String.valueOf(letrasNif.charAt(moduloNif)))) {
            //Si el if es correcto cambio la variable a true
            nifCorrecto = true;
        }
        if (!nifCorrecto){
            nifValido= "SinDNI";
        }
        else {
            nifValido=nif;
        }
        return nifValido;
    }
}

