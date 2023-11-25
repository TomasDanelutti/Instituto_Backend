package com.example.instiutoBackend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cursos")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurso;
    @NotBlank(message = "El nombre es requerido")
    private String nombre;
    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idPrograma")
    private Archivo programa;
    @NotNull
    private String turno;
    @NotNull
    private Long cupoMinimo;
    @NotNull
    private Long cupoMaximo;
    @NotNull
    private LocalDate fechaInicio;
    @NotNull
    private LocalDate fechaFinalizacion;

    private String aula;
    @NotNull
    private String modalidad;
    @NotNull
    private String horario;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "idProfesor")
    private Empleado profesor;
    @Column(unique = true)
    private String estado;

    private boolean activo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idImagen")
    private Archivo imagen;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idTrabajo")
    private List<Trabajo> trabajos;
}
