package com.example.instiutoBackend.web.Curso;

import com.example.instiutoBackend.model.Curso;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CursoController {

    List<Curso> findCursosPaginados(Integer pageNo, Integer pageSize);


    Long count();
    Curso guardarCurso(Curso curso, BindingResult result) throws Exception;

    void eliminarCurso(Long idCurso) throws Exception;

    List<Curso> findCursoByNombre(String nombre);

    List<Curso> findCursoNoInscriptosByUsuario(Long idUsuario);

    List<Curso> findCursoInscriptosByUsuario(Long idUsuario);
}
