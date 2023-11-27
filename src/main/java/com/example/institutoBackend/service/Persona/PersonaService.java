package com.example.institutoBackend.service.Persona;


import com.example.institutoBackend.model.Persona;

public interface PersonaService {

    Persona login(Long dni, String clave) throws Exception;

    Persona findUsuarioByDni(Long dni) ;

    void findAlumnoByDni(Long dni);



}
