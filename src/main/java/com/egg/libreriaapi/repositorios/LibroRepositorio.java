package com.egg.libreriaapi.repositorios;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import org.springframework.stereotype.Repository;

import com.egg.libreriaapi.entidades.Libro;
import com.egg.libreriaapi.modelos.LibroListarActivosDTO;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Integer> {

//Directamente, recupero la info que se precisa en la BBDD creando una isntancia de LibroListarActivosDTO
    @Query("SELECT new com.egg.libreriaapi.modelos.LibroListarActivosDTO(l.titulo, l.ejemplares) " +
            "FROM Libro l WHERE l.alta = true")
    List<LibroListarActivosDTO> encontrarActivos();

}