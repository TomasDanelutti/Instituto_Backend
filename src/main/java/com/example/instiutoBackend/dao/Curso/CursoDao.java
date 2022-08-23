package com.example.instiutoBackend.dao.Curso;

import com.example.instiutoBackend.model.Curso;
import com.example.instiutoBackend.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CursoDao extends JpaRepository<Curso, Long> {

    List<Curso> findAll();

    Curso findCursoByIdCurso(Long idCurso);

    List<Curso> findCursosByEstado(Estado estado);

    List<Curso> findCursosByNombreContainingIgnoreCase(String nombre);

    @Query("from Curso c inner join Inscripcion i on i.curso.idCurso = c.idCurso where i.usuario.idUsuario = :idUsuario")
    List<Curso> findCursoInscriptosByUsuario(Long idUsuario);

    @Query("from Curso c inner join Inscripcion i on i.curso.idCurso = c.idCurso where i.usuario.idUsuario != :idUsuario")
    List<Curso> findCursoNoInscriptosByUsuario(Long idUsuario);

}

