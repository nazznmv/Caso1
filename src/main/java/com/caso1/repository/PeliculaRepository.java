package com.caso1.repository;

import com.caso1.entity.Pelicula;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface PeliculaRepository extends CrudRepository<Pelicula,Long>{
    
}
