package com.br.eletronicapp.models;


import jakarta.persistence.Lob;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import lombok.Data;

/**
 *
 * @author Evandro
 */
@Data
//@MappedSuperclass
public class ImageFile {

    @Lob
    private byte[] imagem;

    public static byte[] readAllBytes(Paths path) throws IOException {
        
        byte[] bytes_Imagens = Files.readAllBytes(Paths.get("D:\\NetBeansProjects\\assets\\produto-"));
        return bytes_Imagens;
        
    }
}
