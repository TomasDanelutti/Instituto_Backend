package com.example.institutoBackend.dao.Curso;

import com.example.institutoBackend.model.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CursoDao extends JpaRepository<Curso, Long> {

    Page<Curso> findCursosByNombreContainingIgnoreCase(Pageable pageable, String nombre);
    Page<Curso> findAllBy(Pageable pageable);
    Long countCursosByNombreContainingIgnoreCase(String nombre);
    Long countCursosBy();

    @Query("from Curso c where c.idCurso = :idCurso")
    Curso findCursoByIdCurso(Long idCurso);

    //Cursos inscriptos por persona
    @Query("from Curso c inner join Inscripcion i on i.curso.idCurso = c.idCurso AND i.activo = true where i.alumno.idPersona = :idPersona")
    Page<Curso> findCursoInscriptosByPersona(Long idPersona, Pageable pageable);

    //Cantidad de cursos inscriptos por persona
    @Query("SELECT COUNT(c) FROM Curso c INNER JOIN Inscripcion i ON i.curso.idCurso = c.idCurso " +
            "WHERE i.alumno.idPersona = :idPersona " +
            "AND i.activo = true")
    Long countCursoInscriptosByPersona(Long idPersona);


    //Cursos inscriptos por persona y nombre
    @Query("FROM Curso c INNER JOIN Inscripcion i ON i.curso.idCurso = c.idCurso " +
            "WHERE i.activo = true AND i.alumno.nombre LIKE %:nombre% AND i.alumno.idPersona = :idPersona")
    Page<Curso> findCursoInscriptosByPersonaAndNombre(Long idPersona, String nombre, Pageable pageable);

    //Cantidad de cursos inscriptos por persona y nombre
    @Query(value = "SELECT COUNT(c) FROM Curso c INNER JOIN Inscripcion i ON i.curso.idCurso = c.idCurso " +
            "WHERE i.activo = true AND i.alumno.nombre LIKE %:nombre% AND i.alumno.idPersona = :idPersona",
            countQuery = "SELECT COUNT(c) FROM Curso c INNER JOIN Inscripcion i ON i.curso.idCurso = c.idCurso " +
                    "WHERE i.activo = true AND i.alumno.nombre LIKE %:nombre% AND i.alumno.idPersona = :idPersona")
    Long countCursoInscriptosByPersonaAndNombre(Long idPersona, String nombre);

    //Cursos no inscriptos por persona
    @Query("from Curso c inner join Inscripcion i on i.curso.idCurso != c.idCurso AND i.activo = true where i.alumno.idPersona != :idPersona")
    Page<Curso> findCursoNoInscriptosByPersona(Long idPersona, Pageable pageable);

    //Cantidad de cursos no inscriptos por persona
    @Query(value = "SELECT COUNT(c) FROM Curso c INNER JOIN Inscripcion i ON i.curso.idCurso != c.idCurso " +
            "WHERE i.activo = true AND i.alumno.idPersona != :idPersona",
            countQuery = "SELECT COUNT(c) FROM Curso c INNER JOIN Inscripcion i ON i.curso.idCurso != c.idCurso " +
                    "WHERE i.activo = true AND i.alumno.idPersona != :idPersona")
    Long countCursoNoInscriptosByPersona(Long idPersona);

    //Cursos no inscriptos por persona y nombre
    @Query("from Curso c inner join Inscripcion i on i.curso.idCurso != c.idCurso AND i.activo = true AND i.alumno.nombre LIKE %:nombre% where i.alumno.idPersona != :idPersona")
    Page<Curso> findCursoNoInscriptosByPersonaAndNombre(Long idPersona, String nombre, Pageable pageable);

    //Cantidad de cursos no inscriptos por persona y nombre
    @Query(value = "SELECT COUNT(c) FROM Curso c INNER JOIN Inscripcion i ON i.curso.idCurso != c.idCurso " +
            "WHERE i.activo = true AND i.alumno.nombre LIKE %:nombre% AND i.alumno.idPersona != :idPersona",
            countQuery = "SELECT COUNT(c) FROM Curso c INNER JOIN Inscripcion i ON i.curso.idCurso != c.idCurso " +
                    "WHERE i.activo = true AND i.alumno.nombre LIKE %:nombre% AND i.alumno.idPersona != :idPersona")
    Long countCursoNoInscriptosByPersonaAndNombre(Long idPersona, String nombre);
}

