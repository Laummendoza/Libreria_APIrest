package com.egg.libreriaapi.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egg.libreriaapi.entidades.Editorial;
import com.egg.libreriaapi.servicios.EditorialServicio;

@RestController
@RequestMapping("/editorial")
public class EditorialControlador {
    @Autowired
    private EditorialServicio editorialServicio;


    @PostMapping("/crear")
    public ResponseEntity<Object> crearEditorial(String nombre) {
        try {
            editorialServicio.crearEditorial(nombre);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<Object> listarEditoriales() {
        try {
            List<Editorial> editoriales = editorialServicio.listarEditoriales(); // Llama al servicio para obtener la lista de editoriales
            return new ResponseEntity<>(editoriales,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listar/altaTrue")
    public ResponseEntity<Object> editorialesActivas() {
        try {
            List<Editorial> editoriales = editorialServicio.editorialesActivas(); // Llama al servicio para obtener la lista de editoriales activas
            return new ResponseEntity<>(editoriales,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listar/altaFalse")
    public ResponseEntity<Object> editorialesInactivas() {
        try {
            List<Editorial> editoriales = editorialServicio.editorialesInactivas(); // Llama al servicio para obtener la lista de editoriales inactivas
            return new ResponseEntity<>(editoriales,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    

    @PatchMapping("/modificar")
    public ResponseEntity<Object> modificarEditorial(Integer idEditorial, String nombre) {
        try {
            editorialServicio.modificarEditorial(idEditorial, nombre);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
