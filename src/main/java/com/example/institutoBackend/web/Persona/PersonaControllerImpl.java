package com.example.institutoBackend.web.Persona;

import com.example.institutoBackend.model.Persona;
import com.example.institutoBackend.service.Persona.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class PersonaControllerImpl implements PersonaController {
    private final PersonaService personaService;

    @Override
    @GetMapping("/findBy/{dni}")
    @ResponseStatus(HttpStatus.OK)
    public String findAlumnoByDni(@PathVariable("dni") Long dni) throws IOException {
        Persona persona = personaService.findUsuarioByDni(dni);
        Assert.isNull(persona, "El DNI ingresado corresponde a una cuenta existente.");
        return "";
    }

}
