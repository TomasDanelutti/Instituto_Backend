package com.example.instiutoBackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notificacionesDesinscripcion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificacionDesinscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotificacionDesinscripcion;

    @ManyToOne
    @JoinColumn(name = "idAlumno")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "idCurso")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "idEmpleado")
    private Empleado empleado;

    private Date fechaCreacionNotificacion;

    private String motivo;

    private boolean estado;

    private String token;
}
