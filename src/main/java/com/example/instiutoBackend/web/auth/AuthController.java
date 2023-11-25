package com.example.instiutoBackend.web.auth;

import com.example.instiutoBackend.model.Persona;
import com.example.instiutoBackend.model.Respuesta;
import com.example.instiutoBackend.model.SolicitudGenerarClave;

import java.io.IOException;
import java.util.UUID;

public interface AuthController {

    Respuesta olvideMiClave(Long dni) throws IOException;

    Persona getUsuario(UUID uuid);

    Respuesta cambiarClave(SolicitudGenerarClave solicitudGenerarClave);
}
