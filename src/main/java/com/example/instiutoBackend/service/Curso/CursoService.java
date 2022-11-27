package com.example.instiutoBackend.service.Curso;

import com.example.instiutoBackend.model.Curso;

import java.util.List;
import java.util.Set;

public interface CursoService {

    List<Curso> findCursosPaginados(Integer pageNo, Integer pageSize);

    Long count();

    void guardarCurso(Curso curso) throws Exception;

    void eliminarCurso(Long idCurso) throws Exception;


    List<Curso> findCursoByNombre(String nombre);

    List<Curso> findCursosInscriptosByUsuario(Long idUsuario);

    Set<Curso> findCursosNoInscriptosByUsuario(Long idUsuario);

    List<Curso> findAllByActivo(boolean activo);
}
