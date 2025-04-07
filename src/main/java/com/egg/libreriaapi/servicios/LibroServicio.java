package com.egg.libreriaapi.servicios;

import com.egg.libreriaapi.entidades.*;
import com.egg.libreriaapi.repositorios.*;
import com.egg.libreriaapi.excepciones.MyException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class LibroServicio {

    @Autowired
    private LibroRepositorio libroRepositorio;
    @Autowired
    private AutorRepositorio autorRepositorio;
    @Autowired
    private EditorialRepositorio editorialRepositorio;
//CREAR LIBRO
    @Transactional
    public void crearLibro(Integer idLibro, String titulo, Integer ejemplares, Boolean alta, Integer idAutor,
            Integer idEditorial) throws MyException {

        validar( titulo, ejemplares, idAutor, idEditorial);

        Autor autor = autorRepositorio.findById(idAutor).orElse(null);
        Editorial editorial = editorialRepositorio.findById(idEditorial).orElse(null);

        if (autor == null) {
            throw new MyException("El autor especificado no existe.");
        }

        if (editorial == null) {
            throw new MyException("La editorial especificada no existe.");
        }
        

        Libro libro = new Libro();
        libro.setIdLibro(idLibro);
        libro.setTitulo(titulo);
        libro.setEjemplares(ejemplares);
        //establecer True por defecto ( si no se hace esto, se inicializa alta=false por defecto)
        if (libro.getAlta() == null) {
            autor.setAlta(true);
        } else {
            autor.setAlta(alta);
        }
        libro.setAlta(alta);
        libro.setAutor(autor);
        libro.setEditorial(editorial);

        libroRepositorio.save(libro);
    }
//LISTAR LIBROS
    @Transactional(readOnly = true)
    public List<Libro> listarLibros() {

        List<Libro> libros = new ArrayList<>();

        libros = libroRepositorio.findAll();
        return libros;
    }
//MODIFICAR LIBRO
    @Transactional
    public void modificarLibro(Integer idLibro, String titulo, Integer ejemplares, Integer idAutor, Integer idEditorial)
            throws MyException {

        validar(titulo, ejemplares, idAutor, idEditorial);

        
        Optional<Libro> respuesta = libroRepositorio.findById(idLibro);
        Optional<Autor> respuestaAutor = autorRepositorio.findById(idAutor);
        Optional<Editorial> respuestaEditorial = editorialRepositorio.findById(idEditorial);

        if (respuesta.isEmpty()) {
            throw new MyException("El libro especificado no existe.");
        }

        if (respuestaAutor.isEmpty()) {
            throw new MyException("El autor especificado no existe.");
        }

        if (respuestaEditorial.isEmpty()) {
            throw new MyException("La editorial especificada no existe.");
        }

        Libro libro = respuesta.get();
        libro.setTitulo(titulo);
        libro.setEjemplares(ejemplares);
        libro.setAutor(respuestaAutor.get());
        libro.setEditorial(respuestaEditorial.get());

        libroRepositorio.save(libro);
    }


    
//BUSCAR POR ID
    @Transactional(readOnly = true)
    public Libro getOne(Integer idLibro) {
        return libroRepositorio.findById(idLibro).orElse(null);
    }

// VALIDAR ATRIBUTOS
    private void validar(String titulo, Integer ejemplares, Integer idAutor, Integer idEditorial)
            throws MyException {

        
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new MyException("El título no puede ser nulo o estar vacío.");
        }
        if (ejemplares == null) {
            throw new MyException("La cantidad de ejemplares no puede ser nula.");
        }

        if (idAutor == null) {
            throw new MyException("El ID del autor no puede ser nulo o estar vacío.");
        }
        if (idEditorial == null) {
            throw new MyException("El ID de la editorial no puede ser nulo o estar vacío.");
        }
    }

}
