package com.egg.libreriaapi.entidades;
import jakarta.persistence.*;   




@Entity
@Table(name = "editorial")
public class Editorial {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_editorial")
    private Integer idEditorial;

    @Column(name = "alta_editorial")
    private Boolean alta;
    
    @Column(name = "nombre_editorial")
    private String nombre;

    public Editorial() {
    }
    public Editorial(Integer idEditorial, Boolean alta, String nombre) {
        this.idEditorial = idEditorial;
        this.alta = alta;
        this.nombre = nombre;
    }
    public Integer getIdEditorial() {
        return idEditorial;
    }
    public void setIdEditorial(Integer idEditorial) {
        this.idEditorial = idEditorial;
    }
    public Boolean getAlta() {
        return alta;
    }
    public void setAlta(Boolean alta) {
        this.alta =alta;

    }    
    public String getNombre() {
        return nombre;
    }       
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return "Editorial{" +
                "idEditorial=" + idEditorial +
                ", alta=" + alta +
                ", nombre='" + nombre + '\'' +
                '}';
    }
   
    
}
