package com.example.institutoBackend.web.Login;

import com.example.institutoBackend.model.Persona;
import com.example.institutoBackend.service.Persona.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginControllerImpl implements LoginController{
    private final PersonaService personaService;

    @Override
    @GetMapping("/{dni}/{clave}")
    @ResponseStatus(HttpStatus.OK)
    public Persona findByDniAndClave(@PathVariable("dni") Long dni,
                                     @PathVariable("clave") String clave) throws Exception {
        return personaService.login(dni, clave);
    }
}
