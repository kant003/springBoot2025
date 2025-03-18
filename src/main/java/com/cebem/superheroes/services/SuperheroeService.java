package com.cebem.superheroes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.cebem.superheroes.entities.Superheroe;
import com.cebem.superheroes.repositories.SuperheroeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SuperheroeService {

    //@Autowired
    //private SuperheroeRepository repository;

    private final SuperheroeRepository repository;
   
    public List<Superheroe> getAll(){
        return repository.findAll();
    }

    public Superheroe save(Superheroe superheroe){
        return repository.save(superheroe);
    }

    public Optional<Superheroe> getById(Long id){
        return repository.findById(id);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public List<Superheroe> findByName(String name){
        return repository.findByNombreContainingIgnoreCase(name);
    }

 /*    public Optional<Superheroe> update(Long id, Superheroe superheroe){
        Optional<Superheroe> data = repository.findById(id);
        data.get()
    } */

}
