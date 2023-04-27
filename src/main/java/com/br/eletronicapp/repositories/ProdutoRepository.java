
package com.br.eletronicapp.repositories;

import com.br.eletronicapp.dto.ProdutoDTO;
import com.br.eletronicapp.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Evandro
 */
@Repository

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
