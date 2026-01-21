package com.example.automotora.repositories;

import com.example.automotora.models.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

@Repository
// cambie de crudrepository a jparepository como salia en el video 2
// tiene mas funciones de paginacion y ordenamiento gratis
public interface CursoRepository extends JpaRepository<Curso, Integer> {
}