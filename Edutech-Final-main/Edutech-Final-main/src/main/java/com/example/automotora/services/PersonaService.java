package com.example.automotora.services;

import com.example.automotora.models.entities.Persona;
import com.example.automotora.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository; // conexion con la bd

    // metodo para listar
    public List<Persona> listarPersonas() {
        // saque el casteo (List<Persona>) pq al cambiar a jparepository ya devuelve una lista directa
        return personaRepository.findAll();
    }

    // metodo para agregar
    public Persona guardarPersona(Persona persona) {
        return personaRepository.save(persona);
    }
}