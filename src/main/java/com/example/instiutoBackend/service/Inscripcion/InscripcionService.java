package com.example.instiutoBackend.service.Inscripcion;

import com.example.instiutoBackend.model.Curso;
import com.example.instiutoBackend.model.Inscripcion;
import com.example.instiutoBackend.model.Usuario;

import java.util.List;

public interface InscripcionService {

    Inscripcion inscribirse(Inscripcion inscripcion) throws Exception;

    List<Usuario> findAlumnosByCurso(Long idCurso);
}
