

package com.egg.libreriaapi.repositorios;
import com.egg.libreriaapi.entidades.Autor;
import com.egg.libreriaapi.entidades.Editorial;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, Integer> {

    
    Optional<Autor> findById(Integer idAutor);
    

}
