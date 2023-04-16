
package com.br.eletronicapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
@Column(name = "imagem")
private byte[] imagem;
    private Long codigo;
    private Byte[] bytes;
    
    public static byte[] readAllBytes(Path path) throws IOException{
         byte[] bytes_Imagens = Files.readAllBytes(Paths.get("C:\\Users\\Evandro\\Documents\\NetBeansProjects\\EletronicApp\\assets")); 
        return  bytes_Imagens;
    }
}
