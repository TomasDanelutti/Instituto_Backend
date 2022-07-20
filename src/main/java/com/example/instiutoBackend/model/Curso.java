package com.example.instiutoBackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDate;

@Entity
@Table(name = "curso")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurso;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idPrograma")
    private Programa programa;

    private String turno;

    private Long cupoMinimo;

    private Long cupoMaximo;

    private LocalDate fecha;

    private String profesor;

    private Estado estado;

    private String imagen;

}
