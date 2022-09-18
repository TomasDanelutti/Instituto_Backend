package com.example.instiutoBackend.service.Curso;

import com.example.instiutoBackend.model.Curso;

import java.util.List;

public interface CursoService {

    List<Curso> findCursosPaginados(Integer pageNo, Integer pageSize);

    Long count();

    Curso guardarCurso(Curso curso) throws Exception;

    void eliminarCurso(Long idCurso) throws Exception;


    List<Curso> findCursoByNombre(String nombre);

    List<Curso> findCursoInscriptosByUsuario(Long idUsuario);

    List<Curso> findCursoNoInscriptosByUsuario(Long idUsuario);
}
