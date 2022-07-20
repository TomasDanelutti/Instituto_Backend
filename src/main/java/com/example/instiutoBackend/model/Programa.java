package com.example.instiutoBackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "programa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Programa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrograma;

    private String nombre;

    private String descripcion;

    private Estado estado;

}
