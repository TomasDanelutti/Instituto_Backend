package com.example.instiutoBackend.dao.Alumno;

import com.example.instiutoBackend.model.Alumno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlumnoDao extends JpaRepository<Alumno, Long> {

    Page<Alumno> findAll(Pageable pageable);
    Page<Alumno> findAlumnosByNombreContainingIgnoreCase(String nombre, Pageable pageable);
    Long countAlumnosBy();
    Long countAlumnosByNombreContainingIgnoreCase(String nombre);
    Alumno findAlumnoByIdPersona(Long idPersona);
}
