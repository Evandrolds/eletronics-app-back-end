package com.br.eletronicapp.contato.repositoties;

import com.br.eletronicapp.models.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Evandro
 */
@Repository
public interface ContatoRepositoty extends JpaRepository<Contato, Integer>{
    
}
