package com.example.instiutoBackend.service.NotificacionDesinscripcion;

import com.example.instiutoBackend.model.DTOS.NotificacionDesinscripcionDTO;
import com.example.instiutoBackend.model.NotificacionDesinscripcion;
import com.example.instiutoBackend.model.Respuesta;

import java.util.List;

public interface NotificacionDesinscripcionService {


    List<NotificacionDesinscripcion> findSolicitudesActivas();
    Respuesta guardarSolicitudDesinscripcion(NotificacionDesinscripcionDTO notificacionesDesinscripcionDTO);

    Respuesta eliminarSolicitudDesinscripcion(Long idNotificacionesDescripcion);
}
