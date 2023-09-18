package com.example.instiutoBackend.web.Alumno;

import com.example.instiutoBackend.model.Alumno;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

public interface AlumnoController {

    List<Alumno> getAlumnosPaginado(Integer pageNo, Integer pageSize, Optional<String> nombre);

    Long contarAlumnos(Optional<String> nombre);

    Alumno guardarAlumno(Alumno alumno, BindingResult result) throws Exception;
}
