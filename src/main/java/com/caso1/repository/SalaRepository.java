package com.caso1.repository;

import com.caso1.entity.Sala;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface SalaRepository extends CrudRepository<Sala,Long>{
    
}
