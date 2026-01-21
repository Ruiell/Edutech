package com.example.automotora.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank; 
import lombok.Data;

@Data 
@Entity
@Table(name="curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // le agregue esta validacion pq el profe dijo que no podian quedar vacios
    @NotBlank(message = "el curso tiene que tener nombre") 
    private String nombre;      
    
    private String descripcion; 
    private int precio;         

    // aqui hago la conexion con el instructor
    // un curso tiene un solo instructor 
    @ManyToOne
    @JoinColumn(name = "id_instructor", nullable = false)
    private Instructor instructor;
}