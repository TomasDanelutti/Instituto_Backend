package com.example.institutoBackend.web.Desinscripcion;

import com.example.institutoBackend.model.Desinscripcion;
import com.example.institutoBackend.model.Respuesta;

import java.io.IOException;
import java.util.List;

public interface DesinscripcionController {

    List<Desinscripcion> findSolicitudesActivas();

    Long contarDesinscripcionesActivas();

    void getToken(Long idCurso, Long idALumno, String motivo) throws IOException;

    Respuesta guardarDesinscripcion(Long idCurso, Long idALumno, String motivo, String token);

    Respuesta eliminarDesinscripcion(Long idAlumno, Long idEmpleado, Long idCurso, String motivo) throws IOException;

}
