package com.example.instiutoBackend.dao.Curso;

import com.example.instiutoBackend.model.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface CursoDao extends JpaRepository<Curso, Long> {

    Page<Curso> findAllBy(Pageable page);

    Long countCursosBy();

    List<Curso> findCursosByActivo(boolean activo);

    @Query("from Curso c where c.idCurso = :idCurso")
    Curso findCursoByIdCurso(Long idCurso);

    List<Curso> findCursosByNombreContainingIgnoreCase(String nombre);

    @Query("from Curso c inner join Inscripcion i on i.curso.idCurso = c.idCurso where i.alumno.idUsuario = :idUsuario")
    List<Curso> findCursoInscriptosByUsuario(Long idUsuario);

    @Query("from Curso c inner join Inscripcion i on i.curso.idCurso = c.idCurso where i.alumno.idUsuario != :idUsuario")
    Set<Curso> findCursoNoInscriptosByUsuario(Long idUsuario);

    List<Curso> findAllByActivo(boolean activo);

}

