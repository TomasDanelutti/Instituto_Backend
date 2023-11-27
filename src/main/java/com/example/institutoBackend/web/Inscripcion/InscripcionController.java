package com.example.institutoBackend.web.Inscripcion;

import com.example.institutoBackend.model.Respuesta;

public interface InscripcionController {

    Respuesta inscribirse(Long idCurso, Long idPersona) throws Exception;

    Respuesta desinscribirse(Long idCurso, Long idPersona) throws Exception;
}
