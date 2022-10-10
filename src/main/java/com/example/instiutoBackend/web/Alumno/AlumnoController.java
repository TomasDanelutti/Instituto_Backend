package com.example.instiutoBackend.web.Alumno;

import com.example.instiutoBackend.model.Alumno;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface AlumnoController {

    List<Alumno> findAlumnosPaginados(Integer pageNo, Integer pageSize);

    Long contarAlumnos();

    Alumno guardarAlumno(Alumno alumno, BindingResult result) throws Exception;

    List<Alumno> findAlumnosByNombre(String nombre);
}
