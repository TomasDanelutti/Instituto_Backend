package com.example.instiutoBackend.service.Desinscripcion;

import com.example.instiutoBackend.model.DTOS.DesinscripcionDTO;
import com.example.instiutoBackend.model.Desinscripcion;
import com.example.instiutoBackend.model.Respuesta;

import java.io.IOException;
import java.util.List;

public interface DesinscripcionService {


    List<Desinscripcion> findSolicitudesActivas();

    void getToken(DesinscripcionDTO desinscripcionDTO) throws IOException;

    Respuesta guardarDesinscripcion(DesinscripcionDTO desinscripcionDTO);

    Long contarDesinscripcionesActivas();

    Respuesta cancelarDescripcion(DesinscripcionDTO desinscripcionDTO) throws IOException;

    Respuesta eliminarDesinscripcion(Long idNotificacionesDescripcion);
}
