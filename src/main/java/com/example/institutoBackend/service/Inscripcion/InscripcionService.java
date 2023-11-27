package com.example.institutoBackend.service.Inscripcion;


import com.example.institutoBackend.model.Respuesta;

public interface InscripcionService {

    Respuesta inscribirse(Long idCurso, Long idPersona) throws Exception;

    Respuesta desinscribirse(Long idCurso, Long idPersona) throws Exception;
}
