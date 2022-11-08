package com.example.instiutoBackend.service.NotificacionDesinscripcion;

import com.example.instiutoBackend.dao.NotificacionDesinscripcion.NotificacionDesinscripcionDao;
import com.example.instiutoBackend.model.DTOS.NotificacionDesinscripcionDTO;
import com.example.instiutoBackend.model.NotificacionDesinscripcion;
import com.example.instiutoBackend.model.Respuesta;

import java.util.List;

public interface NotificacionDesinscripcionService {


    List<NotificacionDesinscripcion> findSolicitudesActivas();

    Respuesta guardarSolicitudDesinscripcion(NotificacionDesinscripcionDTO notificacionesDesinscripcionDTO);


    Long contarNotificacionesDesinscripcionActivas();

    Respuesta eliminarSolicitudDesinscripcion(Long idNotificacionesDescripcion);
}
