

package com.egg.libreriaapi.controladores;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.egg.libreriaapi.entidades.Autor;


import com.egg.libreriaapi.servicios.AutorServicio;


@RestController
@RequestMapping("/autor")
public class AutorControlador {
    //Instancio al servicio, para poder acceder a sus métodos.
    @Autowired
    private AutorServicio autorServicio;


   
    @PostMapping("/crear")
    public ResponseEntity<Object> crearAutor(String nombre) {
        try {
            autorServicio.crearAutor(nombre);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


   @PatchMapping("/modificar")
    public ResponseEntity<Void> modificarAutor(@RequestParam String nombre, @RequestParam Integer id) {
        try {
            autorServicio.modificarAutor(nombre, id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/listar")
    public ResponseEntity<Object> listarAutores() {
        try {
            List<Autor> autores = autorServicio.listarAutores(); // Llama al servicio para obtener la lista de autores
            return new ResponseEntity<>(autores,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/buscar")
    public ResponseEntity<Object> buscarAutor(@RequestParam Integer idAutor) {
        try {
            Autor autor = autorServicio.getOne(idAutor); // Llama al servicio para obtener la lista de autores
            return new ResponseEntity<>(autor,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    
   
    }
}