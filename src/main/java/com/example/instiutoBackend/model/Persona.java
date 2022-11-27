package com.example.instiutoBackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @ColumnDefault("uuid_generate_v4()")
    private UUID uuid;

    private Long dni;
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

    @ManyToOne
    @JoinColumn(name = "idRol")
    private Rol rol;


    public String findNombreApellido() {
        return nombre + ", " + apellido;
    }

    public static String cadenaAleatoria(int longitud) {
        // El banco de caracteres
        String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        // La cadena en donde iremos agregando un carácter aleatorio
        String cadena = "";
        for (int x = 0; x < longitud; x++) {
            int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
            char caracterAleatorio = banco.charAt(indiceAleatorio);
            cadena += caracterAleatorio;
        }
        return cadena;
    }

    public static int numeroAleatorioEnRango(int minimo, int maximo) {
        // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }
}
