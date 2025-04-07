
package com.egg.libreriaapi.entidades;
import jakarta.persistence.*;




@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @Column(name = "id_libro")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idLibro;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "ejemplares")
    private Integer ejemplares;
   
    @Column(name = "alta_libro")
    private Boolean alta = true;                       
    
     
    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

    
    @ManyToOne
    @JoinColumn(name = "id_editorial")
    private Editorial editorial;


    public Libro(Integer idLibro, String titulo, Integer ejemplares, Boolean alta, Autor autor, Editorial editorial) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.ejemplares = ejemplares;
        this.alta = true;
        this.autor = autor;
        this.editorial = editorial;
    }


    public Libro(String titulo, Integer ejemplares, Boolean alta, Autor autor, Editorial editorial) {
        this.titulo = titulo;
        this.ejemplares = ejemplares;
        this.alta = true;
        this.autor = autor;
        this.editorial = editorial;
    }


    public Libro() {
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


    public Boolean getAlta() {
        return alta;
    }


    public Autor getAutor() {
        return autor;
    }


    public Editorial getEditorial() {
        return editorial;
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


    public void setAlta(Boolean alta) {
        this.alta = true;
    }


    public void setAutor(Autor autor) {
        this.autor = autor;
    }


    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    
    
}
