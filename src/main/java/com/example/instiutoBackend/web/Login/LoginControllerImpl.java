package com.example.instiutoBackend.web.Login;

import com.example.instiutoBackend.model.Persona;
import com.example.instiutoBackend.service.Persona.PersonaService;
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
