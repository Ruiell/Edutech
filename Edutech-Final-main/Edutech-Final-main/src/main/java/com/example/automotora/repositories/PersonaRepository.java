package com.example.automotora.repositories;

import com.example.automotora.models.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

@Repository
// lo paso a jparepository para que quede igual que los otros dos
// asi tenemos las funciones avanzadas listas por si acaso
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}