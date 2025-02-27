package com.cebem.superheroes.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;

import com.cebem.superheroes.entities.Superheroe;
import com.cebem.superheroes.services.SuperheroeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.repository.support.Repositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/superheroes")
@RequiredArgsConstructor
public class SuperheroeController {

    private final SuperheroeService service;

    @GetMapping("/saludar")
    public String saludar() {
        return "Hola desde springboot";
    }
    
    //GET http://localhost:8080/api/superheroes 
    @GetMapping("")
    public List<Superheroe> getAll(){
        return service.getAll();
    }   

    //GET http://localhost:8080/api/superheroes/xxx
    @GetMapping("/{id}")
    public ResponseEntity<Superheroe> getById(@PathVariable Long id){
        Optional<Superheroe> data = service.getById(id);
        if(!data.isPresent()) return ResponseEntity.notFound().build();
        
        return ResponseEntity.ok(data.get()) ;

        // return data.map(ResponseEntity::ok).orElseGet( ()->ResponseEntity.notFound().build() );
    }


    // POST http://localhost:8080/api/superheroes
    // {body}
    @PostMapping("")
    public ResponseEntity<Superheroe> save(@Valid @RequestBody Superheroe superheroe) {
       return ResponseEntity.ok(service.save(superheroe)) ;
    }
    
  


    
    


}
