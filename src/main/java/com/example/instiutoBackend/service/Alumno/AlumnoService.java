package com.example.instiutoBackend.service.Alumno;

import com.example.instiutoBackend.model.Alumno;
import com.example.instiutoBackend.model.EXTS.AlumnoEXTS;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface AlumnoService {

    List<Alumno> getAlumnosPaginado(Integer pageNo, Integer pageSize, Optional<String> nombre);

    Long contarAlumnos(Optional<String> nombre);

    Alumno guardarAlumno(AlumnoEXTS alumno) throws IOException;
}
