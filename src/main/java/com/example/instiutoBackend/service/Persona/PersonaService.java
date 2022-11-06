package com.example.instiutoBackend.service.Persona;

import com.example.instiutoBackend.model.Persona;

public interface PersonaService {

    Persona login(Long dni, String clave) throws Exception;

    Persona findUsuarioByDni(Long dni) ;

    void findAlumnoByDni(Long dni);



}
