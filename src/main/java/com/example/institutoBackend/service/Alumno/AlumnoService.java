package com.example.institutoBackend.service.Alumno;


import com.example.institutoBackend.model.Alumno;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface AlumnoService {

    List<Alumno> getAlumnosPaginado(Integer pageNo, Integer pageSize, Optional<String> nombre);

    Long contarAlumnos(Optional<String> nombre);

    Alumno guardarAlumno(Alumno alumno) throws IOException;
}
