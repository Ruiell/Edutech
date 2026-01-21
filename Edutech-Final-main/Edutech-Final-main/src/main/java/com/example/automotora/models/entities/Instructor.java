package com.example.automotora.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank; // <--- IMPORTANTE
import lombok.Data;

@Data
@Entity
@Table(name="instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // este se genera solo, auto incrementable

    @NotBlank(message = "El nombre es obligatorio") // validacion para que no guarden instructores sin nombre
    private String nombre;

    private String email;
    private String especialidad;
}