package com.example.instiutoBackend.service.Inscripcion;

import com.example.instiutoBackend.model.Curso;
import com.example.instiutoBackend.model.Inscripcion;
import com.example.instiutoBackend.model.InscripcionDTO;
import com.example.instiutoBackend.model.Usuario;

import java.util.List;

public interface InscripcionService {

    Inscripcion inscribirse(InscripcionDTO inscripcionDTO) throws Exception;

    List<Usuario> findAlumnosByCurso(Long idCurso);
}
