package com.example.automotora.services;

import com.example.automotora.models.entities.Curso;
import com.example.automotora.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; // <--- importar para el status http
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException; 
import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> listar() {
        // como ahora uso jparepository, no necesito castear la lista, es directo
        return cursoRepository.findAll();
    }

    public Curso guardar(Curso curso) {
        return cursoRepository.save(curso);
    }

    // aqui cambie el null por una excepcion 404 
    // asi si buscan un curso que no existe, el programa avisa
    public Curso buscarPorId(int id) {
        return cursoRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "no pille el curso con ese id"));
    }

    public void eliminar(int id) {
        // primero verifico si existe antes de intentar borrar
        if (!cursoRepository.existsById(id)) {
             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no se puede borrar pq no existe ese id");
        }
        cursoRepository.deleteById(id);
    }
}