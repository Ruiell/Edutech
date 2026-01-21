package com.example.automotora.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank; 
import lombok.Data;

@Data 
@Entity
@Table(name="persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona") 
    private int id;

    // el rut no se puede repetir y no puede ser nulo
    @Column(unique = true, nullable = false)
    @NotBlank(message = "el rut es obligatorio") 
    private String rut;

    @NotBlank(message = "el nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "el apellido es obligatorio")
    private String apellido;

    private String direccion;
    private String telefono;    
}