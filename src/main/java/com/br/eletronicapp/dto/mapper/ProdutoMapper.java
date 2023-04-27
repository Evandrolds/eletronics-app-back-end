package com.br.eletronicapp.dto.mapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Dizendo ao spring que essa classe é uma classe de configuração,
 * atravéz do anotation (@Configuration).
 * 
 * Passando para o spring o (@Bean) do método de configuração que desejo utilizar,
 * para que o spring configure para mim.
 * 
 * @author Evandro
 */
 
@Configuration
public class ProdutoMapper {
    
     
    @Bean
    public ModelMapper toDTO() {
        return new ModelMapper();
    }
   
}
