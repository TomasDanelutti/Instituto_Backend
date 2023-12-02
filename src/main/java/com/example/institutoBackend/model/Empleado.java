package com.example.institutoBackend.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "empleados")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Empleado extends Persona {
    @NotNull
    private Long sueldo;

    @ManyToOne
    @JoinColumn(name = "idPuestoEmpleado")
    private PuestoEmpleado puestoEmpleado;
}
