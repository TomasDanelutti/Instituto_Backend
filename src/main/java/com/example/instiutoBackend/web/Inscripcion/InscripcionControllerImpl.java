package com.example.instiutoBackend.web.Inscripcion;

import com.example.instiutoBackend.model.DTOS.InscripcionDTO;
import com.example.instiutoBackend.model.Respuesta;
import com.example.instiutoBackend.model.Persona;
import com.example.instiutoBackend.service.Inscripcion.InscripcionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/inscripcion")
@RequiredArgsConstructor
public class InscripcionControllerImpl implements InscripcionController {

    private final InscripcionService inscripcionService;

    @Override
    @PostMapping("/inscribirse")
    @ResponseStatus(HttpStatus.OK)
    public Respuesta inscribirse(@Validated @RequestBody InscripcionDTO inscripcionDTO, BindingResult result) throws Exception {

        if (result.hasErrors()) {
            throw new Exception("Datos incompletos");
        }
        return inscripcionService.inscribirse(inscripcionDTO);
    }

    @Override
    @PostMapping("/desinscribirse")
    @ResponseStatus(HttpStatus.OK)
    public Respuesta desinscribirse(@Validated @RequestBody InscripcionDTO inscripcionDTO, BindingResult result) throws Exception {
        System.out.println(inscripcionDTO);
        if (result.hasErrors()) {
            throw new Exception("Datos incompletos");
        }
        return inscripcionService.desinscribirse(inscripcionDTO);
    }

    @Override
    @GetMapping("/alumnos/{idCurso}")
    @ResponseStatus(HttpStatus.OK)
    public List<Persona> findAlumnosByCurso(@PathVariable("idCurso") Long idCurso) {
        return inscripcionService.findAlumnosByCurso(idCurso);
    }


}
