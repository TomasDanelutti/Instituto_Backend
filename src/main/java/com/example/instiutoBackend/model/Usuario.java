package com.example.instiutoBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String nombre;

    private String apellido;

    private Long telefono;

    private String domicilio;

    private Long dni;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String clave;

    private String genero;

    private String mail;

    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "idRol")
    private Rol rol;
}
