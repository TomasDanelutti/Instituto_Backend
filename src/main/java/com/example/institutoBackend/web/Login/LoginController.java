package com.example.institutoBackend.web.Login;


import com.example.institutoBackend.model.Persona;

public interface LoginController {

    Persona findByDniAndClave(Long dni, String clave) throws Exception;
}
