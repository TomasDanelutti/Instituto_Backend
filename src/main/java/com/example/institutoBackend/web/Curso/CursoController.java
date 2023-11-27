package com.example.institutoBackend.web.Curso;

import com.example.institutoBackend.model.Curso;
import com.example.institutoBackend.model.Respuesta;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

public interface CursoController {
    List<Curso> GetCursosPaginado(Integer pageNo, Integer pageSize, Optional<String> nombre);
    Long countCursos(Optional<String> nombre);
    Curso guardarCurso(Curso curso, BindingResult result) throws Exception;

    Respuesta eliminarCurso(Long idCurso) throws Exception;


    List<Curso> findCursoNoInscriptosByUsuario(Long idUsuario);

    List<Curso> findCursoInscriptosByUsuario(Long idUsuario);

    List<Curso> findAllByActivo(boolean activo);

    List<Curso> findCursosInscriptosByUsuarioAndNombre(Long idUsuario, Optional<String> nombre);

    List<Curso> findCursosNoInscriptosByUsuarioAndNombre(Long idUsuario, Optional<String> nombre);


}
