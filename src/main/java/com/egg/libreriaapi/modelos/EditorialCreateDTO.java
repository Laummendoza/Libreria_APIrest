package com.egg.libreriaapi.modelos;

public class EditorialCreateDTO {

    private String nombre;
    private boolean alta;

    public EditorialCreateDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

}
