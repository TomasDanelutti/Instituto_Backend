package com.example.instiutoBackend.service.Alumno;

import com.example.instiutoBackend.model.Alumno;
import com.example.instiutoBackend.model.EXTS.AlumnoEXTS;

import java.util.List;

public interface AlumnoService {

    List<Alumno> findAlumnosPaginados(Integer pageNo, Integer pageSize);

    Long contarALumnos();

    Alumno guardarAlumno(AlumnoEXTS alumno);

    List<Alumno> findALumnosByNombre(String nombre);

}
