package com.example.instiutoBackend.web.Curso;

import com.example.instiutoBackend.model.Curso;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public interface CursoController {

    List<Curso> findAll();

    Curso guardarCurso(Curso curso, BindingResult result) throws Exception;

    Curso eliminarCurso(@RequestBody Curso curso, BindingResult result) throws Exception;

    List<Curso> findCursoByNombre(String nombre);

    List<Curso> findCursoNoInscriptosByUsuario(Long idUsuario);

    List<Curso> findCursoInscriptosByUsuario(Long idUsuario);
}
