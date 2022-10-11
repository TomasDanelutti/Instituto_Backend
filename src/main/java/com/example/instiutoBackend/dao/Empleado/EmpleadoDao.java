package com.example.instiutoBackend.dao.Empleado;

import com.example.instiutoBackend.model.Empleado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpleadoDao extends JpaRepository<Empleado, Long> {

    Page<Empleado> findAll(Pageable page);

    Long countEmpleadosBy();

    List<Empleado> findEmpleadoByNombreIgnoreCase(String nombre);

    List<Empleado> findEmpleadoByPuesto(String puesto);
}
