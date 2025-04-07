package com.egg.libreriaapi.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egg.libreriaapi.entidades.Autor;
import com.egg.libreriaapi.excepciones.MyException;
import com.egg.libreriaapi.repositorios.AutorRepositorio;

@Service
public class AutorServicio {

    @Autowired
    private AutorRepositorio autorRepositorio;

    // CREAR AUTOR
    @Transactional
    public void crearAutor(String nombre) throws MyException {
        Autor autor = new Autor();
        autor.setNombre(nombre);
        validar(nombre);

        autorRepositorio.save(autor);
    }

    // LISTAR AUTORES
    @Transactional(readOnly = true)
    public List<Autor> listarAutores() {

        List<Autor> autores = new ArrayList<>();

        autores = autorRepositorio.findAll();
        return autores;
    }

    // MODIFICAR AUTOR
    @Transactional
    public void modificarAutor(String nombre, Integer idAutor) throws MyException {
        validar(nombre);
        Optional<Autor> respuesta = autorRepositorio.findById(idAutor);

        if (respuesta.isPresent()) {
            Autor autor = respuesta.get();
            autor.setNombre(nombre);
            autorRepositorio.save(autor);
        } else {
            throw new MyException("No se encontró un autor con el ID especificado");
        }
    }
    // DAR DE BAJA UN AUTOR

    @Transactional
    public void eliminarAutor(Integer idAutor) throws MyException {
        Autor autor = autorRepositorio.findById(idAutor)
                .orElseThrow(() -> new MyException("No se encontró un autor con el ID proporcionado."));

        autor.setAlta(false);
        autorRepositorio.save(autor);
    }

    // BUSCAR AUTOR POR ID
    @Transactional(readOnly = true)
    public Autor getOne(Integer idAutor) {
        return autorRepositorio.findById(idAutor).orElse(null);
    }

    // VALIDAR NOMBRE AUTOR
    private void validar(String nombre) throws MyException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new MyException("El nombre no puede ser nulo o estar vacío");
        }
    }

}