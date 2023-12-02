package com.example.institutoBackend.web.Persona;

import com.example.institutoBackend.model.Persona;
import com.example.institutoBackend.service.Persona.PersonaService;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/personas")
@RequiredArgsConstructor
public class PersonaControllerImpl implements PersonaController {

    private final PersonaService personaService;

    @Override
    @GetMapping()
    @PreAuthorize("hasAuthority('ROLE_INSTITUCION') or hasAuthority('ROLE_EMPLEADO') or hasAuthority('ROLE_ALUMNO')")
    public Persona getPersonaSession() {
        return personaService.getPersonaSession();
    }
}
