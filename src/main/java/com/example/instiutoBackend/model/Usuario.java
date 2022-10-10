package com.example.instiutoBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private Long dni;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String clave;

    private String nombre;

    private String apellido;

    private String domicilio;

    private Long telefono;

    private String genero;

    private String email;

    private Estado estado;

    private Date fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "idImagen")
    private Archivo imagen;

    @ManyToOne
    @JoinColumn(name = "idRol")
    private Rol rol;

}
