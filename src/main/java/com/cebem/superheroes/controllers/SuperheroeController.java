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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




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
    @CrossOrigin
    public List<Superheroe> getAll(){
        return service.getAll();
    }   

    //GET http://localhost:8080/api/superheroes/xxx
    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Superheroe> getById(@PathVariable Long id){
        Optional<Superheroe> data = service.getById(id);
        if(!data.isPresent()) return ResponseEntity.notFound().build();
        
        return ResponseEntity.ok(data.get()) ;

        // return data.map(ResponseEntity::ok).orElseGet( ()->ResponseEntity.notFound().build() );
    }

    //GET http://localhost:8080/api/superheroes/find?nombre=XXX
    @GetMapping("/find")
    @CrossOrigin
    public List<Superheroe> find(@RequestParam String nombre) {
        return service.findByName(nombre);
    }
    


    // POST http://localhost:8080/api/superheroes
    // {body}
    @PostMapping("")
    @CrossOrigin
    public ResponseEntity<Superheroe> save(@Valid @RequestBody Superheroe superheroe) {
       return ResponseEntity.ok(service.save(superheroe)) ;
    }
    
    @DeleteMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Optional<Superheroe> superheroe = service.getById(id);
        if(!superheroe.isPresent()) return ResponseEntity.notFound().build();
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Superheroe> update(@PathVariable Long id, 
                                                 @RequestBody Superheroe superheroe) {
        Optional<Superheroe> dato = service.getById(id);
        if(!dato.isPresent()) return ResponseEntity.notFound().build();
        superheroe.setId(id);
        service.save(superheroe);
        return ResponseEntity.ok(superheroe);
    }

  


    
    


}
