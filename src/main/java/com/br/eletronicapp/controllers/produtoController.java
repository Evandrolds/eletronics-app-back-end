package com.br.eletronicapp.controllers;

/**
 *
 * @author Evandro
 */
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.br.eletronicapp.models.ProdutoModel;
import com.br.eletronicapp.services.ProdutoService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/produtos")
@AllArgsConstructor
public class produtoController {
    
    private final ProdutoService service;

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> getAll() {
        return new ResponseEntity<>(service.getAllProdutos(), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<ProdutoModel> insert(@RequestBody ProdutoModel eletronic) {
        service.insertProduto(eletronic);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(path ="/upload-image/{id}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<ProdutoModel> upload(@PathVariable("id") Integer id, @RequestPart("file") MultipartFile uploadFile) {
        service.updatePicture(id, uploadFile);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Integer id) {

        try {
            ProdutoModel produtoModel = service.findProdutoById(id);

            byte[] image = Files.readAllBytes(Paths.get(produtoModel.getImagem()));

            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    
}
