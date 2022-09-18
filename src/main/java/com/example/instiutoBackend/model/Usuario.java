package com.example.instiutoBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "usuario")
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

    private String imagen;

    @ManyToOne
    @JoinColumn(name = "idRol")
    private Rol rol;

}
