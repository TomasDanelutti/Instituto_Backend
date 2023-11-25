package com.example.instiutoBackend.service.auth;

import com.example.instiutoBackend.model.Respuesta;
import com.example.instiutoBackend.model.SolicitudGenerarClave;
import com.example.instiutoBackend.model.Persona;

import java.io.IOException;
import java.util.UUID;

public interface AuthService {

    Respuesta olvideMiClave(Long dni) throws IOException;

    Persona getUsuario(UUID uuid);

    Respuesta cambiarClave(SolicitudGenerarClave solicitudGenerarClave);

}
