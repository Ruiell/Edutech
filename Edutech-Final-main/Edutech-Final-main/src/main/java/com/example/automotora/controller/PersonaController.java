package com.example.automotora.controller;

import com.example.automotora.models.entities.Persona;
import com.example.automotora.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/emp") // esto hace que todo empiece con /emp, asi lo pidieron al principio
public class PersonaController {

    @Autowired
    private PersonaService personaService; // conecto con el servicio

    // para ver la lista en el navegador: localhost:8080/emp/listar
    @GetMapping("/listar")
    public List<Persona> listar() {
        return personaService.listarPersonas();
    }

    // para guardar uno nuevo: localhost:8080/emp/agregar
    @PostMapping("/agregar")
    public Persona agregar(@RequestBody Persona persona) {
        return personaService.guardarPersona(persona);
    }
}