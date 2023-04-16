package com.br.eletronicapp.contato.services;

import com.br.eletronicapp.contato.repositoties.ContatoRepositoty;
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
