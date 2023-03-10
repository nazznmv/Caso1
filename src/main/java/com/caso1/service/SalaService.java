package com.caso1.service;

import com.caso1.entity.Sala;
import com.caso1.repository.SalaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaService implements ISalaService{
    
    @Autowired
    private SalaRepository salaRepository;
    
    @Override
    public List<Sala> listCountry(){
        return (List<Sala>)salaRepository.findAll();
    }
}
