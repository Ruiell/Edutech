package com.example.automotora.services;

import com.example.automotora.models.entities.Instructor;
import com.example.automotora.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; 
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException; 
import java.util.List;

@Service
public class InstructorService {

    @Autowired // inyeccion de dependencias, para usar el repo sin instanciarlo yo
    private InstructorRepository instructorRepository;

    public List<Instructor> listar() {
        return instructorRepository.findAll();
    }

    public Instructor guardar(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    // aqui busque como manejar el error si no encuentra el id
    // lanza un 404 en vez de null para que se entienda mejor en postman
    public Instructor buscarPorId(int id) {
        return instructorRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No se encontró el instructor con ID: " + id));
    }

    public void eliminar(int id) {
        // primero verifico si existe antes de intentar borrar
        if (!instructorRepository.existsById(id)) {
             throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No se puede eliminar, ID no existe: " + id);
        }
        instructorRepository.deleteById(id);
    }
}