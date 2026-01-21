package com.example.automotora.controller; 

import com.example.automotora.models.entities.Instructor;
import com.example.automotora.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/instructores") 
public class InstructorController {

    @Autowired
    private InstructorService instructorService; // llamo al servicio que tiene la logica

    // get para traer la lista completa
    @GetMapping
    public List<Instructor> listar() {
        return instructorService.listar();
    }

    // post para guardar uno nuevo, el requestbody convierte el json a objeto java
    @PostMapping
    public Instructor guardar(@RequestBody Instructor instructor) {
        return instructorService.guardar(instructor);
    }

    // put para editar, recibo el id por url y los datos nuevos en el cuerpo
    @PutMapping("/{id}")
    public Instructor actualizar(@PathVariable int id, @RequestBody Instructor instructorActualizado) {
        // primero busco si existe
        Instructor instructorExistente = instructorService.buscarPorId(id);
        
        // le agregue este if para que no se caiga si el id no existe (igual que en curso)
        if (instructorExistente != null) {
            instructorExistente.setNombre(instructorActualizado.getNombre());
            instructorExistente.setEspecialidad(instructorActualizado.getEspecialidad());
            instructorExistente.setEmail(instructorActualizado.getEmail());
            
            // guardo los cambios
            return instructorService.guardar(instructorExistente);
        }
        return null;
    }

    // delete para borrar por id
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        instructorService.eliminar(id);
    }
}