package com.example.instiutoBackend.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cursos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurso;

    private String nombre;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPrograma")
    private Archivo programa;

    private String turno;

    private Long cupoMinimo;

    private Long cupoMaximo;

    private LocalDate fechaInicio;

    private LocalDate fechaFinalizacion;

    private String aula;

    private String modalidad;

    private String horario;

    @ManyToOne
    @JoinColumn(name = "idProfesor")
    private Empleado profesor;

    private Estado estado;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idImagen")
    private Archivo imagen;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idTrabajo")
    private List<Trabajo> trabajos;
}
