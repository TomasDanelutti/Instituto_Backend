package com.example.institutoBackend.model;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuariosLogin")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuarioLogin;

    private Long dni;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String clave;

}
