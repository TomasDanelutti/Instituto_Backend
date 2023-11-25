package com.example.instiutoBackend.service.Inscripcion;

import com.example.instiutoBackend.model.Respuesta;

public interface InscripcionService {

    Respuesta inscribirse(Long idCurso, Long idPersona) throws Exception;

    Respuesta desinscribirse(Long idCurso, Long idPersona) throws Exception;
}
