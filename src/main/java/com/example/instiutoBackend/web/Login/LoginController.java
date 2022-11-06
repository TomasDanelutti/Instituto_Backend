package com.example.instiutoBackend.web.Login;

import com.example.instiutoBackend.model.Persona;

public interface LoginController {

    Persona findByDniAndClave(Long dni, String clave) throws Exception;
}
