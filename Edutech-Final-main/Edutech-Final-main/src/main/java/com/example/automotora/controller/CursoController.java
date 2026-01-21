package com.example.automotora.controller;

import com.example.automotora.models.entities.Curso;
import com.example.automotora.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService; // conecto con el servicio   
    
    // metodo para listar todos los cursos disponibles
    @GetMapping
    public List<Curso> listar() {
        return cursoService.listar();
    }

    // metodo para guardar uno nuevo
    @PostMapping
    public Curso guardar(@RequestBody Curso curso) {
        return cursoService.guardar(curso);
    }

    // metodo para actualizar, primero busca si existe y luego reemplaza los datos
    @PutMapping("/{id}")
    public Curso actualizar(@PathVariable int id, @RequestBody Curso cursoActualizado) {
        Curso cursoExistente = cursoService.buscarPorId(id);
        
        if (cursoExistente != null) {
            cursoExistente.setNombre(cursoActualizado.getNombre());
            cursoExistente.setDescripcion(cursoActualizado.getDescripcion());
            cursoExistente.setPrecio(cursoActualizado.getPrecio());
            cursoExistente.setInstructor(cursoActualizado.getInstructor());
            return cursoService.guardar(cursoExistente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        cursoService.eliminar(id);
    }
}