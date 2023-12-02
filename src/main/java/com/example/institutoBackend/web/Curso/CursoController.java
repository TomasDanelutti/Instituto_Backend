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

    List<Curso> findCursosByUsuarioAndNombre(Optional<String> nombre, boolean inscripto, Integer numPage , Integer pageSize);

    Long countCursosByUsuarioAndNombre(Optional<String> nombre, boolean inscripto);
}
