package com.example.instiutoBackend.web.NotificacionDesinscripcion;

import com.example.instiutoBackend.model.DTOS.NotificacionDesinscripcionDTO;
import com.example.instiutoBackend.model.NotificacionDesinscripcion;
import com.example.instiutoBackend.model.Respuesta;

import java.util.List;

public interface NotificacionDesinscripcionController {

    List<NotificacionDesinscripcion> findSolicitudesActivas();

    Long contarNotificacionesDesinscripcionActivas();

    Respuesta guardarSolicitudDesinscripcion(NotificacionDesinscripcionDTO notificacionesDesinscripcionDTO);

}
