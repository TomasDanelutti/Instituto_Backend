package com.example.instiutoBackend.web.Inscripcion;

import com.example.instiutoBackend.model.Curso;
import com.example.instiutoBackend.model.Inscripcion;
import com.example.instiutoBackend.service.Inscripcion.InscripcionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/inscripcion")
@RequiredArgsConstructor
public class InscripcionControllerImpl implements InscripcionController {

    private final InscripcionService inscripcionService;

    @Override
    @PostMapping("/insc")
    @ResponseStatus(HttpStatus.OK)
    public Inscripcion inscribirse(@RequestBody Inscripcion inscripcion, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            throw new Exception("Datos incompletos");
        }
        return inscripcionService.inscribirse(inscripcion);
    }


}
