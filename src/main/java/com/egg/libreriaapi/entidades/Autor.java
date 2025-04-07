
package com.egg.libreriaapi.entidades;

import jakarta.persistence.*;




@Entity
@Table(name = "Autor")
public class Autor {
    @Id
    @Column(name = "id_autor")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAutor;

    @Column(name = "nombre_autor")
    private String nombre;

    @Column(name = "alta_autor")
    private Boolean alta;


    

    public Autor() {
    }

    
    public Autor(String nombre, Boolean alta) {
        this.nombre = nombre;
        this.alta = true;
    }


    public Autor(Integer idAutor, String nombre, Boolean alta) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.alta = true;
    }

    public Integer getIdAutor() {
        return idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAlta(Boolean alta) {
        this.alta = true;
    }
    @Override
    public String toString() {
        return "Autor{" +
                "idAutor=" + idAutor +
                ", nombre='" + nombre + '\'' +
                ", alta=" + alta +
                '}';
    }

    

}
