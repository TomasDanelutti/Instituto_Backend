package com.example.instiutoBackend.dao.Desinscripcion;

import com.example.instiutoBackend.model.Desinscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DesinscripcionDao extends JpaRepository<Desinscripcion, Long> {

    @Query("from Desinscripcion d where d.estado = true")
    List<Desinscripcion> findNotificacionesActivas();

    Long countAllByEstadoIsTrue();

    @Query("from Desinscripcion d where d.alumno.idUsuario = :idPersona AND d.curso.idCurso = :idCurso AND d.estado = true")
    Desinscripcion findDesinscripcionByAlumno_IdUsuarioAndCurso_IdCursoAAndEstadoIsTrue(Long idPersona, Long idCurso);
}
