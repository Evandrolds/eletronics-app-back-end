package com.br.eletronicapp.services;

import com.br.eletronicapp.repositories.ContatoRepositoty;
import com.br.eletronicapp.models.Contato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Evandro
 */
@Service
public class ContatoService {
    
    @Autowired
    private ContatoRepositoty  repository;
    
    public Contato salvarContato(Contato contato){
       return repository.save(contato);
    }
}
