package com.example.instiutoBackend.dao.Curso;

import com.example.instiutoBackend.model.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface CursoDao extends JpaRepository<Curso, Long> {

    Page<Curso> findCursosByNombreContainingIgnoreCase(Pageable pageable, String nombre);
    Page<Curso> findAllBy(Pageable pageable);
    Long countCursosByNombreContainingIgnoreCase(String nombre);
    Long countCursosBy();
    List<Curso> findCursosByActivo(boolean activo);

    @Query("from Curso c where c.idCurso = :idCurso")
    Curso findCursoByIdCurso(Long idCurso);

    @Query("from Curso c inner join Inscripcion i on i.curso.idCurso = c.idCurso AND i.activo = true where i.alumno.idPersona = :idPersona")
    List<Curso> findCursoInscriptosByPersona(Long idPersona);

    @Query("from Curso c inner join Inscripcion i on i.curso.idCurso != c.idCurso AND i.activo = true where i.alumno.idPersona != :idPersona")
    List<Curso> findCursoNoInscriptosByPersona(Long idPersona);

    @Query("from Curso c inner join Inscripcion i on i.curso.idCurso = c.idCurso AND i.alumno.idPersona = :idPersona AND i.activo = true where i.alumno.idPersona is null")
    List<Curso> findCursoInscriptosByPersonaa(Long idPersona);


    List<Curso> findAllByActivo(boolean activo);

}

