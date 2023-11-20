package com.example.instiutoBackend.web.Curso;

import com.example.instiutoBackend.model.Curso;
import com.example.instiutoBackend.model.Respuesta;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CursoController {
    List<Curso> GetCursosPaginado(Integer pageNo, Integer pageSize, Optional<String> nombre);
    Long countCursos(Optional<String> nombre);
    Curso guardarCurso(Curso curso, BindingResult result) throws Exception;

    Respuesta eliminarCurso(Long idCurso) throws Exception;


    List<Curso> findCursoNoInscriptosByUsuario(Long idUsuario);

    List<Curso> findCursoInscriptosByUsuario(Long idUsuario);

    List<Curso> findAllByActivo(boolean activo);


}
