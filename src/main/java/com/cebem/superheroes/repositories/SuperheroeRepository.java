package com.cebem.superheroes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cebem.superheroes.entities.Superheroe;

@Repository
public interface SuperheroeRepository extends JpaRepository<Superheroe, Long> {
    
}
