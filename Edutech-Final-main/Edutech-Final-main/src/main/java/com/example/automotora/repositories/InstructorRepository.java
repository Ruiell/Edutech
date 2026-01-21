package com.example.automotora.repositories;

import com.example.automotora.models.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

@Repository
// cambie a jparepository pq tiene mas funciones que el crudrepository basico
// esto hace la magia de conectar con la base de datos mysql
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
    
}