package com.example.instiutoBackend.service.Inscripcion;

import com.example.instiutoBackend.model.*;
import com.example.instiutoBackend.model.DTOS.InscripcionDTO;

import java.util.List;

public interface InscripcionService {

    Respuesta inscribirse(InscripcionDTO inscripcionDTO) throws Exception;

    Respuesta desinscribirse(InscripcionDTO inscripcionDTO) throws Exception;

    List<Persona> findAlumnosByCurso(Long idCurso);

}
