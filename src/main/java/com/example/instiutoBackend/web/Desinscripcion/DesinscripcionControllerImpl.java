package com.example.instiutoBackend.web.Desinscripcion;

import com.example.instiutoBackend.model.Desinscripcion;
import com.example.instiutoBackend.model.Respuesta;
import com.example.instiutoBackend.service.Desinscripcion.DesinscripcionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/desinscripciones")
@RequiredArgsConstructor
public class DesinscripcionControllerImpl implements DesinscripcionController {

    private final DesinscripcionService desinscripcionService;

    @Override
    @GetMapping("/findActivos")
    @ResponseStatus(HttpStatus.OK)
    public List<Desinscripcion> findSolicitudesActivas() {
        return desinscripcionService.findSolicitudesActivas();
    }

    @Override
    @GetMapping("/count")
    @ResponseStatus(HttpStatus.OK)
    public Long contarDesinscripcionesActivas() {
        return desinscripcionService.contarDesinscripcionesActivas();
    }

    @Override
    @PostMapping("/getToken")
    @ResponseStatus(HttpStatus.OK)
    public void getToken(
            @RequestParam("idCurso") Long idCurso,
            @RequestParam("idAlumno") Long idAlumno,
            @RequestParam("motivo") String motivo) throws IOException {
        desinscripcionService.getToken(idCurso, idAlumno, motivo);
    }

    @Override
    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.OK)
    public Respuesta guardarDesinscripcion(
            @RequestParam("idCurso") Long idCurso,
            @RequestParam("idAlumno") Long idAlumno,
            @RequestParam("motivo") String motivo,
            @RequestParam("token") String token) {
        return desinscripcionService.guardarDesinscripcion(idCurso, idAlumno, motivo, token);
    }

    @Override
    @PostMapping("/cancelar")
    @ResponseStatus(HttpStatus.OK)
    public Respuesta eliminarDesinscripcion(
            @RequestParam("idAlumno") Long idAlumno,
            @RequestParam("idEmpleado") Long idEmpleado,
            @RequestParam("idCurso") Long idCurso,
            @RequestParam("motivo") String motivo) throws IOException {
        return desinscripcionService.cancelarDescripcion(idAlumno, idEmpleado, idCurso, motivo);
    }
}
