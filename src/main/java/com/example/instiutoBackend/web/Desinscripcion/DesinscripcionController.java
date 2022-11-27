package com.example.instiutoBackend.web.Desinscripcion;

import com.example.instiutoBackend.model.DTOS.DesinscripcionDTO;
import com.example.instiutoBackend.model.Desinscripcion;
import com.example.instiutoBackend.model.Respuesta;

import java.io.IOException;
import java.util.List;

public interface DesinscripcionController {

    List<Desinscripcion> findSolicitudesActivas();

    Long contarDesinscripcionesActivas();

    void getToken(DesinscripcionDTO desinscripcionDTO) throws IOException;

    Respuesta guardarDesinscripcion(DesinscripcionDTO desinscripcionDTO);

    Respuesta eliminarDesinscripcion(DesinscripcionDTO desinscripcionDTO) throws IOException;

}
