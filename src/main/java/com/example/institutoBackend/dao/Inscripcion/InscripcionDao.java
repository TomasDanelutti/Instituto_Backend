package com.example.institutoBackend.dao.Inscripcion;

import com.example.institutoBackend.model.Inscripcion;
import com.example.institutoBackend.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InscripcionDao extends JpaRepository<Inscripcion, Long> {

//    @Query("from Inscripcion ins where ins.alumno = :idUsuario")

    @Query("from Persona u inner join Inscripcion i on i.alumno.idPersona = u.idPersona where i.curso.idCurso = :idCurso")
    List<Persona> findAlumnosByCurso(Long idCurso);

    @Query("from Persona u inner join Inscripcion i on i.alumno.idPersona = u.idPersona where i.curso.idCurso = :idCurso AND i.alumno.idPersona = :idPersona")
    Persona findAlumnoByCurso(Long idCurso, Long idPersona);

    Inscripcion findByCurso_IdCursoAndAlumno_IdPersona(Long idCurso, Long idPersona);

}

