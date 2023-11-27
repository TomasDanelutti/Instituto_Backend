package com.example.institutoBackend.web.auth;

import com.example.institutoBackend.model.Persona;
import com.example.institutoBackend.model.Respuesta;
import com.example.institutoBackend.model.SolicitudGenerarClave;
import com.example.institutoBackend.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

    private final AuthService authService;

    @Override
    @PostMapping("/olvideMiClave")
    public Respuesta olvideMiClave(@RequestBody Long dni) throws IOException {
        return authService.olvideMiClave(dni);
    }

    @Override
    @GetMapping("/findBy/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public Persona getUsuario(@PathVariable("uuid") UUID uuid) {
        return authService.getUsuario(uuid);
    }

    @Override
    @PostMapping("/cambiarClave")
    public Respuesta cambiarClave(@RequestBody SolicitudGenerarClave solicitudGenerarClave) {
        System.out.println(solicitudGenerarClave);
        return authService.cambiarClave(solicitudGenerarClave);
    }
}
