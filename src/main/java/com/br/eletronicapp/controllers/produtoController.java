package com.br.eletronicapp.controllers;

/**
 *
 * @author Evandro
 */
import com.br.eletronicapp.dto.ProdutoDTO;
import com.br.eletronicapp.exceptions.RecordException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.br.eletronicapp.models.Produto;
import com.br.eletronicapp.services.ProdutoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

@Validated
@RestController
@RequestMapping("/produtos")
@AllArgsConstructor
public class produtoController {
    
    private final ProdutoService service;

    private ModelMapper produtoMapper;
    
    // Get All Products 
    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> getAll() {
        return  ResponseEntity.ok().body( service.getAllProdutos());
    }
    
    // Insert Products
    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProdutoDTO> insert(@RequestBody Produto produto) {
        service.insertProduto(produto);
        return ResponseEntity.ok().build();
    }
    // Product find by id
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO>findById(@PathVariable("id") @NotNull @Positive Integer id) throws RecordException{
        return new ResponseEntity<>(service.findProdutoById(id),HttpStatus.OK);
    }
    
    // Product update
    @PatchMapping("/update/{id}")
    public ResponseEntity<ProdutoDTO>update(@RequestBody @Valid Produto produto,@PathVariable("id")@NotNull @Positive Integer id) throws RecordException{
        
        return ResponseEntity.ok().body(service.updateProduto(produto,id));
    }
    
    // Product image upload
    @PatchMapping(path ="/upload-image/{id}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Produto> upload(@PathVariable("id") @Positive @NotNull Integer id, @RequestPart("file") MultipartFile uploadFile) {
        
        service.updatePicture(id, uploadFile);
        return ResponseEntity.ok().build();
    }
    // Get image product
    @GetMapping("/produto-/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Integer id) throws RecordException {

        try {
            ProdutoDTO produto= service.findProdutoById(id);

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
