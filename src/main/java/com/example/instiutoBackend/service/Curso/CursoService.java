package com.example.instiutoBackend.service.Curso;

import com.example.instiutoBackend.model.Curso;
import com.example.instiutoBackend.model.Respuesta;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CursoService {

    List<Curso> GetCursosPaginado(Integer pageNo, Integer pageSize, Optional<String> nombre);
    Long countCursos(Optional<String> nombre);
    Curso guardarCurso(Curso curso) throws Exception;

    Respuesta eliminarCurso(Long idCurso) throws Exception;

    List<Curso> findCursosInscriptosByUsuario(Long idUsuario);

    List<Curso> findCursosNoInscriptosByUsuario(Long idUsuario);

    List<Curso> findAllByActivo(boolean activo);

    List<Curso> findCursosInscriptosByUsuarioAndNombre(Long idUsuario, Optional<String> nombre);

    List<Curso> findCursosNoInscriptosByUsuarioAndNombre(Long idUsuario, Optional<String> nombre);
}
