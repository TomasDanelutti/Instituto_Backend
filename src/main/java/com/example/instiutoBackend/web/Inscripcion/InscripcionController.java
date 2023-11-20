package com.example.instiutoBackend.web.Inscripcion;

import com.example.instiutoBackend.model.Respuesta;
import com.example.instiutoBackend.model.Persona;

import java.util.List;

public interface InscripcionController {

    Respuesta inscribirse(Long idCurso, Long idPersona) throws Exception;

    Respuesta desinscribirse(Long idCurso, Long idPersona) throws Exception;
}
