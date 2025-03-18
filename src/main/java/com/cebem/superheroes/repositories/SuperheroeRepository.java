package com.cebem.superheroes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cebem.superheroes.entities.Superheroe;

@Repository
public interface SuperheroeRepository extends JpaRepository<Superheroe, Long> {
    List<Superheroe> findByNombreContainingIgnoreCase(String name);
}
