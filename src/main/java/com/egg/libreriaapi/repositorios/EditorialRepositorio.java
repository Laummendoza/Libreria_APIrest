package com.egg.libreriaapi.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egg.libreriaapi.entidades.Editorial;

@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial, Integer> {
    List<Editorial> findByAltaTrue();
    List<Editorial> findByAltaFalse();
    List<Editorial> findByNombre(String nombre);
    //Optional<Editorial> findById(UUID idEditorial);

}
