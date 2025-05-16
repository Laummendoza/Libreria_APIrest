package com.egg.libreriaapi.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.egg.libreriaapi.modelos.LibroCreateDTO;
import com.egg.libreriaapi.servicios.LibroServicio;


@RestController
@RequestMapping("/libro")
public class LibroControlador {
   
    @Autowired
    private LibroServicio libroServicio;


    @PostMapping("/crear")
    public ResponseEntity<Object> crearLibro(@RequestBody LibroCreateDTO libroCreateDTO) {
        try {
            libroServicio.crearLibro(libroCreateDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"Algun dato no es correcto o es nulo, revisar.\"}");
        }
    }
}