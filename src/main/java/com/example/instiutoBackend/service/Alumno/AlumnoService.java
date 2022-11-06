package com.example.instiutoBackend.service.Alumno;

import com.example.instiutoBackend.model.Alumno;

import java.util.List;

public interface AlumnoService {

    List<Alumno> findAlumnosPaginados(Integer pageNo, Integer pageSize);

    Long contarALumnos();

    Alumno guardarAlumno(Alumno alumno);

    List<Alumno> findALumnosByNombre(String nombre);

}
