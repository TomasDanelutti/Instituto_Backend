package com.example.institutoBackend.web.Inscripcion;

import com.example.institutoBackend.model.Respuesta;
import com.example.institutoBackend.service.Inscripcion.InscripcionService;
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
