
package com.br.eletronicapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;



/**
 *
 * @author Evandro
 */
@Getter
@Setter
public class ProdutoDTO{
        @NotBlank Integer id;
        @NotNull@NotBlank@Length(min = 2,max = 100)
        String nome;
        @NotNull@NotBlank 
        String descricao;
        @NotNull@NotBlank 
        String formaDepagamento;
        @NotNull@NotBlank 
        String imagem;
        @NotNull
        Integer estoque;
        @NotNull
        Double preco;
        
}
