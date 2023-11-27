package com.example.institutoBackend.dao.Desinscripcion;

import com.example.institutoBackend.model.Desinscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DesinscripcionDao extends JpaRepository<Desinscripcion, Long> {

    @Query("from Desinscripcion d where d.estado = true")
    List<Desinscripcion> findNotificacionesActivas();

    Long countAllByEstadoIsTrue();

    @Query("from Desinscripcion d where d.alumno.idPersona = :idPersona AND d.curso.idCurso = :idCurso AND d.estado = true")
    Desinscripcion findDesinscripcionByAlumno_IdPersonaAndCurso_IdCursoAAndEstadoIsTrue(Long idPersona, Long idCurso);
}
