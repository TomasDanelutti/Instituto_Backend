package com.example.institutoBackend.dao.Empleado;

import com.example.institutoBackend.model.Empleado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoDao extends JpaRepository<Empleado, Long> {

    Page<Empleado> findAll(Pageable page);
    Page<Empleado> findEmpleadosByNombreContainingIgnoreCase(String nombre, Pageable pageable);
    Long countEmpleadosBy();
    Long countEmpleadosByNombre(String nombre);

    List<Empleado> findEmpleadoByPuestoEmpleado_IdPuestoEmpleado(Long idPuestoEmlleado);
    Empleado findByIdPersona(Long idPersona);
}
