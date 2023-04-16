/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.eletronicapp.contato.services.controllers;

import com.br.eletronicapp.contato.services.ContatoService;
import com.br.eletronicapp.models.Contato;
import java.net.URI;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Evandro
 */
@RestController
@RequestMapping("/contatos")
public class ContatoController {
    @Autowired
    private ContatoService service;
    
    @PostMapping("/cadastrar")
    public ResponseEntity<?> save(@RequestBody Contato contato){
        service.salvarContato(contato);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
