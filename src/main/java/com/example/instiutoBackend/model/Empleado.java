package com.example.instiutoBackend.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "empleados")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Empleado extends Persona {
    @NotNull
    private Long sueldo;
    @NotNull
    private String puesto;
}
