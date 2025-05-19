package com.egg.libreriaapi.modelos;

public class LibroListarActivosDTO {

    private String titulo;
    private Integer ejemplares;

    public LibroListarActivosDTO() {
    }

    public LibroListarActivosDTO(String titulo, Integer ejemplares) {

        this.titulo = titulo;
        this.ejemplares = ejemplares;

    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

}
