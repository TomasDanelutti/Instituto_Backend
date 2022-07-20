package com.example.instiutoBackend.service.Curso;

import com.example.instiutoBackend.model.Curso;
import com.example.instiutoBackend.model.Programa;

import java.util.List;

public interface CursoService {

    List<Curso> findAll();

    Curso guardarCurso(Curso curso) throws Exception;

    Curso eliminarCurso(Curso curso) throws Exception;

    List<Curso> findCursoInscriptosByUsuario(Long idUsuario);

    List<Curso> findCursoNoInscriptosByUsuario(Long idUsuario);
}
