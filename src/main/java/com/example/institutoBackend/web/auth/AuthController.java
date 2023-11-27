package com.example.institutoBackend.web.auth;

import com.example.institutoBackend.model.Persona;
import com.example.institutoBackend.model.Respuesta;
import com.example.institutoBackend.model.SolicitudGenerarClave;

import java.io.IOException;
import java.util.UUID;

public interface AuthController {

    Respuesta olvideMiClave(Long dni) throws IOException;

    Persona getUsuario(UUID uuid);

    Respuesta cambiarClave(SolicitudGenerarClave solicitudGenerarClave);
}
