package com.example.instiutoBackend.web.Inscripcion;

import com.example.instiutoBackend.model.Respuesta;

public interface InscripcionController {

    Respuesta inscribirse(Long idCurso, Long idPersona) throws Exception;

    Respuesta desinscribirse(Long idCurso, Long idPersona) throws Exception;
}
