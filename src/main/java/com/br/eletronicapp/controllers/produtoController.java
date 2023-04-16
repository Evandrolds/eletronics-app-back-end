package com.br.eletronicapp.controllers;

/**
 *
 * @author Evandro
 */
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.eletronicapp.models.ProdutoModel;
import com.br.eletronicapp.services.ProdutoService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    
}
