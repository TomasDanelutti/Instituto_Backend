package com.example.institutoBackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Desinscripciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Desinscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDesinscripcion;

    @ManyToOne
    @JoinColumn(name = "idAlumno")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "idCurso")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "idEmpleado")
    private Empleado empleado;

    private Date fechaCreacionDesinscripcion;

    private String motivo;

    private boolean estado;

    private String token;
}
