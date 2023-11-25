package com.example.instiutoBackend.service.Inscripcion;

import com.example.instiutoBackend.model.*;

import java.util.List;

public interface InscripcionService {

    Respuesta inscribirse(Long idCurso, Long idPersona) throws Exception;

    Respuesta desinscribirse(Long idCurso, Long idPersona) throws Exception;
}
