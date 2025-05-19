package com.egg.libreriaapi.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egg.libreriaapi.entidades.Autor;
import com.egg.libreriaapi.entidades.Editorial;
import com.egg.libreriaapi.excepciones.MyException;
import com.egg.libreriaapi.modelos.EditorialCreateDTO;
import com.egg.libreriaapi.modelos.LibroCreateDTO;
import com.egg.libreriaapi.repositorios.EditorialRepositorio;

@Service
public class EditorialServicio {

    @Autowired
    private EditorialRepositorio editorialRepositorio;


    

    // CREAR EDITORIAL
    @Transactional
    public void crearEditorial(EditorialCreateDTO editorialCreateDTO) {
//  quede en esta linea de CODIGO!!!!!!
        
        Editorial editorialNueva = new Editorial();// Instancio un objeto del tipo Editorial
        editorialNueva.setNombre(editorialCreateDTO.getNombre());
        editorialNueva.setAlta(editorialCreateDTO.isAlta());// Seteo el atributo, con el valor recibido como parámetro
        editorialRepositorio.save(editorialNueva);// Persisto el dato en mi BBDD
    }

    // LISTAR EDITORIALES
    @Transactional(readOnly = true)
    public List<Editorial> listarEditoriales() {

        List<Editorial> editoriales = new ArrayList<>();

        editoriales = editorialRepositorio.findAll();
        return editoriales;
    }

    // MODIFICAR EDITORIAL
    @Transactional
    public void modificarEditorial(Integer idEditorial, String nombre) throws MyException {
        validar(nombre);

        Optional<Editorial> respuesta = editorialRepositorio.findById(idEditorial);

        if (respuesta.isPresent()) {
            Editorial editorial = respuesta.get();
            editorial.setNombre(nombre);
            editorialRepositorio.save(editorial);
        } else {
            throw new MyException("No se encontró una editorial con el ID especificado");
        }
    }

    // ELIMINAR EDITORIAL
    @Transactional
    public void eliminar(Integer idEditorial) throws MyException {
        Optional<Editorial> editorialOpt = editorialRepositorio.findById(idEditorial);
        if (editorialOpt.isPresent()) {
            editorialRepositorio.delete(editorialOpt.get());
        } else {
            throw new MyException("La editorial con el ID especificado no existe");
        }
    }

    // BUSCAR EDITORIAL POR ID
    @Transactional(readOnly = true)
    public Editorial getOne(Integer idEditorial) {
        return editorialRepositorio.findById(idEditorial).orElse(null);
    }

    // VALIDAR NOMBRE EDITORIAL
    private void validar(String nombre) throws MyException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new MyException("El nombre de la editorial no puede ser nulo o estar vacío");
        }
    }

    // LISTAR EDITORIALES activas
    @Transactional(readOnly = true)
    public List<Editorial> editorialesActivas() {

        return editorialRepositorio.findByAltaTrue();
    }
    // LISTAR EDITORIALES inactivas
    @Transactional(readOnly = true)
    public List<Editorial> editorialesInactivas() {

        return editorialRepositorio.findByAltaFalse();
    }



    


}
