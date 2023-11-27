package com.example.institutoBackend.service.Desinscripcion;


import com.example.institutoBackend.model.Desinscripcion;
import com.example.institutoBackend.model.Respuesta;

import java.io.IOException;
import java.util.List;

public interface DesinscripcionService {


    List<Desinscripcion> findSolicitudesActivas();

    void getToken(Long idCurso, Long idALumno, String motivo) throws IOException;

    Respuesta guardarDesinscripcion(Long idCurso, Long idALumno, String motivo, String token);

    Long contarDesinscripcionesActivas();

    Respuesta cancelarDescripcion(Long idAlumno, Long idEmpleado, Long idCurso, String motivo) throws IOException;

    Respuesta eliminarDesinscripcion(Long idNotificacionesDescripcion);
}
