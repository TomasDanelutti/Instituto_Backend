package com.example.instiutoBackend.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "imagenes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Archivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArchivo;

    @NotNull
    private String nombre;

    @NotNull
    private String foto;

}
