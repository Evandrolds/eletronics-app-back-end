
package com.br.eletronicapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configurando o cors para utilizar a porta do servidor web da aplicação que está
 * executando em porta diferente do meu back-end.
 * @author Evandro
 */
@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer{
    
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**");
    }
    
}
