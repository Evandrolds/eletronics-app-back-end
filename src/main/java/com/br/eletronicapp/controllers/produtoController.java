package com.br.eletronicapp.controllers;

/**
 *
 * @author Evandro
 */
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.br.eletronicapp.models.Produto;
import com.br.eletronicapp.services.ProdutoService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/produtos")
@AllArgsConstructor
public class produtoController {
    
    private final ProdutoService service;
    
    // Get All Products 
    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        return new ResponseEntity<>(service.getAllProdutos(), HttpStatus.OK);
    }
    
    // Insert Products
    @PostMapping("/insert")
    public ResponseEntity<Produto> insert(@RequestBody Produto produto) {
        service.insertProduto(produto);
        return ResponseEntity.ok().build();
    }
    // Product find by id
    @GetMapping("/{id}")
    public ResponseEntity<Produto>findById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(service.findProdutoById(id),HttpStatus.OK);
    }
    
    // Product update
    @PatchMapping("/update/{id}")
    public ResponseEntity<Produto>update(@RequestBody Produto produto,@PathVariable("id") Integer id){
        
        return ResponseEntity.ok().body(service.updateProduto(produto,id));
    }
    
    // Product image upload
    @PatchMapping(path ="/upload-image/{id}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Produto> upload(@PathVariable("id") Integer id, @RequestPart("file") MultipartFile uploadFile) {
        
        service.updatePicture(id, uploadFile);
        return ResponseEntity.ok().build();
    }
    // Get image product
    @GetMapping("/produto-/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Integer id) {

        try {
            Produto produto= service.findProdutoById(id);

            byte[] image = Files.readAllBytes(Paths.get(produto.getImagem()));
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(image);
           
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    
}
