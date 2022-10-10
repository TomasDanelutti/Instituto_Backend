package com.example.instiutoBackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "trabajos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trabajo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTrabajo;

    private String tipo;

    private Long nota;
}
