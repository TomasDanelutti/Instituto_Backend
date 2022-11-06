package com.example.instiutoBackend.web.Inscripcion;

import com.example.instiutoBackend.model.DTOS.InscripcionDTO;
import com.example.instiutoBackend.model.Respuesta;
import com.example.instiutoBackend.model.Persona;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface InscripcionController {

    Respuesta inscribirse(InscripcionDTO inscripcionDTO, BindingResult result) throws Exception;

    Respuesta desinscribirse(InscripcionDTO inscripcionDTO, BindingResult result) throws Exception;

    List<Persona> findAlumnosByCurso(Long idCurso);

//    Inscripcion solicitudDesinscripcion(InscripcionDTO inscripcionDTO);
}
