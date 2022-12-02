package com.example.instiutoBackend.model.EXTS;

import com.example.instiutoBackend.model.Archivo;

import javax.persistence.*;
import java.util.Date;

public class AlumnoEXTS {

    private Long dni;

    private String clave;

    private String nombre;

    private String apellido;

    private String domicilio;

    private Long telefono;

    private String estadoCivil;

    private String nivelEducativo;

    private String genero;

    private String email;

    private String estado;

    private boolean activo;

    private Date fechaNacimiento;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idImagen")
    private Archivo imagen;
}
