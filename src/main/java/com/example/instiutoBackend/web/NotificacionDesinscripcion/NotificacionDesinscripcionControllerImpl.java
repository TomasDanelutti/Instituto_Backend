package com.example.instiutoBackend.web.NotificacionDesinscripcion;

import com.example.instiutoBackend.model.DTOS.NotificacionDesinscripcionDTO;
import com.example.instiutoBackend.model.NotificacionDesinscripcion;
import com.example.instiutoBackend.model.Respuesta;
import com.example.instiutoBackend.service.NotificacionDesinscripcion.NotificacionDesinscripcionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacionesDesinscripcion")
@RequiredArgsConstructor
public class NotificacionDesinscripcionControllerImpl implements NotificacionDesinscripcionController{

    private final NotificacionDesinscripcionService notificacionDesinscripcionService;

    @Override
    @GetMapping("/findActivos")
    @ResponseStatus(HttpStatus.OK)
    public List<NotificacionDesinscripcion> findSolicitudesActivas() {
        return notificacionDesinscripcionService.findSolicitudesActivas();
    }

    @Override
    @GetMapping("/count")
    @ResponseStatus(HttpStatus.OK)
    public Long contarNotificacionesDesinscripcionActivas() {
        return notificacionDesinscripcionService.contarNotificacionesDesinscripcionActivas();
    }

    @Override
    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.OK)
    public Respuesta guardarSolicitudDesinscripcion(@RequestBody NotificacionDesinscripcionDTO notificacionesDesinscripcionDTO) {
        return notificacionDesinscripcionService.guardarSolicitudDesinscripcion(notificacionesDesinscripcionDTO);
    }
}
