package com.example.instiutoBackend.web.Inscripcion;

import com.example.instiutoBackend.model.Respuesta;
import com.example.instiutoBackend.service.Inscripcion.InscripcionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/inscripcion")
@RequiredArgsConstructor
public class InscripcionControllerImpl implements InscripcionController {

    private final InscripcionService inscripcionService;

    @Override
    @PostMapping("/inscribirse")
    @ResponseStatus(HttpStatus.OK)
    public Respuesta inscribirse(
            @RequestParam("idPersona") Long idPersona,
            @RequestParam("idCurso") Long idCurso) throws Exception {

        return inscripcionService.inscribirse(idPersona, idCurso);
    }

    @Override
    @PostMapping("/desinscribirse")
    @ResponseStatus(HttpStatus.OK)
    public Respuesta desinscribirse(
            @RequestParam("idPersona") Long idPersona,
            @RequestParam("idCurso") Long idCurso) throws Exception {
        return inscripcionService.desinscribirse(idPersona, idCurso);
    }

}
