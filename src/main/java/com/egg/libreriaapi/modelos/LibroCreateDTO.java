package com.egg.libreriaapi.modelos;

public class LibroCreateDTO {

    private Integer idLibro;//Este dato sera utilizado como idLibro
    private String titulo;
    private Integer ejemplares;
    private Integer idAutor;
    private Integer idEditorial;
    private boolean alta;

    public LibroCreateDTO() {
    }

    public Integer getIdLibro() {
        return idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public Integer getIdAutor() {
        return idAutor;
    }

    public Integer getIdEditorial() {
        return idEditorial;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public void setIdEditorial(Integer idEditorial) {
        this.idEditorial = idEditorial;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

}
